package com.myorga.code.rest;

import com.myorga.code.domain.Label;
import com.myorga.code.repository.LabelRepository;
import com.myorga.code.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.myorga.technique.web.HeaderUtil;
import com.myorga.technique.web.ResponseUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * REST controller for managing {@link Label}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class LabelResource {

    private final Logger log = LoggerFactory.getLogger(LabelResource.class);

    private static final String ENTITY_NAME = "label";

    @Value("${clientApp.name}")
    private String applicationName;

    private final LabelRepository labelRepository;

    public LabelResource(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    /**
     * {@code POST  /labels} : Create a new label.
     *
     * @param label the label to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new label, or with status {@code 400 (Bad Request)} if the label has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/labels")
    public ResponseEntity<Label> createLabel(@Valid @RequestBody Label label) throws URISyntaxException {
        log.debug("REST request to save Label : {}", label);
        if (label.getId() != null) {
            throw new BadRequestAlertException("A new label cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Label result = labelRepository.save(label);
        return ResponseEntity
            .created(new URI("/api/labels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /labels/:id} : Updates an existing label.
     *
     * @param id the id of the label to save.
     * @param label the label to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated label,
     * or with status {@code 400 (Bad Request)} if the label is not valid,
     * or with status {@code 500 (Internal Server Error)} if the label couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/labels/{id}")
    public ResponseEntity<Label> updateLabel(@PathVariable(value = "id", required = false) final Long id, @Valid @RequestBody Label label)
        throws URISyntaxException {
        log.debug("REST request to update Label : {}, {}", id, label);
        if (label.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, label.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!labelRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Label result = labelRepository.save(label);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, label.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /labels/:id} : Partial updates given fields of an existing label, field will ignore if it is null
     *
     * @param id the id of the label to save.
     * @param label the label to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated label,
     * or with status {@code 400 (Bad Request)} if the label is not valid,
     * or with status {@code 404 (Not Found)} if the label is not found,
     * or with status {@code 500 (Internal Server Error)} if the label couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/labels/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Label> partialUpdateLabel(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody Label label
    ) throws URISyntaxException {
        log.debug("REST request to partial update Label partially : {}, {}", id, label);
        if (label.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, label.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!labelRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Label> result = labelRepository
            .findById(label.getId())
            .map(existingLabel -> {
                if (label.getLabel() != null) {
                    existingLabel.setLabel(label.getLabel());
                }

                return existingLabel;
            })
            .map(labelRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, label.getId().toString())
        );
    }

    /**
     * {@code GET  /labels} : get all the labels.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of labels in body.
     */
    @GetMapping("/labels")
    public List<Label> getAllLabels() {
        log.debug("REST request to get all Labels");
        return labelRepository.findAll();
    }

    /**
     * {@code GET  /labels/:id} : get the "id" label.
     *
     * @param id the id of the label to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the label, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/labels/{id}")
    public ResponseEntity<Label> getLabel(@PathVariable Long id) {
        log.debug("REST request to get Label : {}", id);
        Optional<Label> label = labelRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(label);
    }

    /**
     * {@code DELETE  /labels/:id} : delete the "id" label.
     *
     * @param id the id of the label to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/labels/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        log.debug("REST request to delete Label : {}", id);
        labelRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
