package com.myorga.technique.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@Component
@ConfigurationProperties(prefix = "project", ignoreUnknownFields = false)
public class ProjectProperties {
    private final ProjectProperties.Async async = new ProjectProperties.Async();
    private final ProjectProperties.Http http = new ProjectProperties.Http();
    private final ProjectProperties.Database database = new ProjectProperties.Database();
    private final ProjectProperties.Cache cache = new ProjectProperties.Cache();
    private final ProjectProperties.Mail mail = new ProjectProperties.Mail();
    private final ProjectProperties.Security security = new ProjectProperties.Security();
    private final ProjectProperties.ApiDocs apiDocs = new ProjectProperties.ApiDocs();
    private final ProjectProperties.Logging logging = new ProjectProperties.Logging();
    private final CorsConfiguration cors = new CorsConfiguration();
    private final ProjectProperties.Social social = new ProjectProperties.Social();
    private final ProjectProperties.Gateway gateway = new ProjectProperties.Gateway();
    private final ProjectProperties.Registry registry = new ProjectProperties.Registry();
    private final ProjectProperties.ClientApp clientApp = new ProjectProperties.ClientApp();
    private final ProjectProperties.AuditEvents auditEvents = new ProjectProperties.AuditEvents();

    public ProjectProperties() {
    }

    public ProjectProperties.Async getAsync() {
        return this.async;
    }

    public ProjectProperties.Http getHttp() {
        return this.http;
    }

    public ProjectProperties.Database getDatabase() {
        return this.database;
    }

    public ProjectProperties.Cache getCache() {
        return this.cache;
    }

    public ProjectProperties.Mail getMail() {
        return this.mail;
    }

    public ProjectProperties.Registry getRegistry() {
        return this.registry;
    }

    public ProjectProperties.Security getSecurity() {
        return this.security;
    }

    public ProjectProperties.ApiDocs getApiDocs() {
        return this.apiDocs;
    }

    public ProjectProperties.Logging getLogging() {
        return this.logging;
    }

    public CorsConfiguration getCors() {
        return this.cors;
    }

    public ProjectProperties.Social getSocial() {
        return this.social;
    }

    public ProjectProperties.Gateway getGateway() {
        return this.gateway;
    }

    public ProjectProperties.ClientApp getClientApp() {
        return this.clientApp;
    }

    public ProjectProperties.AuditEvents getAuditEvents() {
        return this.auditEvents;
    }

    public static class AuditEvents {
        private int retentionPeriod = 30;

        public AuditEvents() {
        }

        public int getRetentionPeriod() {
            return this.retentionPeriod;
        }

        public void setRetentionPeriod(int retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }

    public static class ClientApp {
        private String name = "projectApp";

        public ClientApp() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Registry {
        private String password;

        public Registry() {
            this.password = MyProjectDefaults.Registry.password;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Gateway {
        private final ProjectProperties.Gateway.RateLimiting rateLimiting = new ProjectProperties.Gateway.RateLimiting();
        private Map<String, List<String>> authorizedMicroservicesEndpoints;

        public Gateway() {
            this.authorizedMicroservicesEndpoints = MyProjectDefaults.Gateway.authorizedMicroservicesEndpoints;
        }

        public ProjectProperties.Gateway.RateLimiting getRateLimiting() {
            return this.rateLimiting;
        }

        public Map<String, List<String>> getAuthorizedMicroservicesEndpoints() {
            return this.authorizedMicroservicesEndpoints;
        }

        public void setAuthorizedMicroservicesEndpoints(Map<String, List<String>> authorizedMicroservicesEndpoints) {
            this.authorizedMicroservicesEndpoints = authorizedMicroservicesEndpoints;
        }

        public static class RateLimiting {
            private boolean enabled = false;
            private long limit = 100000L;
            private int durationInSeconds = 3600;

            public RateLimiting() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getLimit() {
                return this.limit;
            }

            public void setLimit(long limit) {
                this.limit = limit;
            }

            public int getDurationInSeconds() {
                return this.durationInSeconds;
            }

            public void setDurationInSeconds(int durationInSeconds) {
                this.durationInSeconds = durationInSeconds;
            }
        }
    }

    public static class Social {
        private String redirectAfterSignIn = "/#/home";

        public Social() {
        }

        public String getRedirectAfterSignIn() {
            return this.redirectAfterSignIn;
        }

        public void setRedirectAfterSignIn(String redirectAfterSignIn) {
            this.redirectAfterSignIn = redirectAfterSignIn;
        }
    }

    public static class Logging {
        private boolean useJsonFormat = false;
        private final ProjectProperties.Logging.Logstash logstash = new ProjectProperties.Logging.Logstash();

        public Logging() {
        }

        public boolean isUseJsonFormat() {
            return this.useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public ProjectProperties.Logging.Logstash getLogstash() {
            return this.logstash;
        }

        public static class Logstash {
            private boolean enabled = false;
            private String host = "localhost";
            private int port = 5000;
            private int queueSize = 512;

            public Logstash() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return this.host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return this.port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getQueueSize() {
                return this.queueSize;
            }

            public void setQueueSize(int queueSize) {
                this.queueSize = queueSize;
            }
        }
    }

    public static class ApiDocs {
        private String title = "Application API";
        private String description = "API documentation";
        private String version = "0.0.1";
        private String termsOfServiceUrl;
        private String contactName;
        private String contactUrl;
        private String contactEmail;
        private String license;
        private String licenseUrl;
        private String defaultIncludePattern;
        private String managementIncludePattern;
        private String host;
        private String[] protocols;
        private ProjectProperties.ApiDocs.Server[] servers;
        private boolean useDefaultResponseMessages;

        public ApiDocs() {
            this.termsOfServiceUrl = MyProjectDefaults.ApiDocs.termsOfServiceUrl;
            this.contactName = MyProjectDefaults.ApiDocs.contactName;
            this.contactUrl = MyProjectDefaults.ApiDocs.contactUrl;
            this.contactEmail = MyProjectDefaults.ApiDocs.contactEmail;
            this.license = MyProjectDefaults.ApiDocs.license;
            this.licenseUrl = MyProjectDefaults.ApiDocs.licenseUrl;
            this.defaultIncludePattern = "/api/.*";
            this.managementIncludePattern = "/management/.*";
            this.host = MyProjectDefaults.ApiDocs.host;
            this.protocols = MyProjectDefaults.ApiDocs.protocols;
            this.servers = new ProjectProperties.ApiDocs.Server[0];
            this.useDefaultResponseMessages = true;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return this.termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return this.contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return this.contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return this.contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return this.license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return this.licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return this.defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getManagementIncludePattern() {
            return this.managementIncludePattern;
        }

        public void setManagementIncludePattern(String managementIncludePattern) {
            this.managementIncludePattern = managementIncludePattern;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return this.protocols;
        }

        public void setProtocols(String[] protocols) {
            this.protocols = protocols;
        }

        public ProjectProperties.ApiDocs.Server[] getServers() {
            return this.servers;
        }

        public void setServers(ProjectProperties.ApiDocs.Server[] servers) {
            this.servers = servers;
        }

        public boolean isUseDefaultResponseMessages() {
            return this.useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }

        public static class Server {
            private String name;
            private String url;
            private String description;

            public Server() {
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

    public static class Security {
        private String contentSecurityPolicy = "default-src 'self'; frame-src 'self' data:; script-src 'self' 'unsafe-inline' 'unsafe-eval' https://storage.googleapis.com; style-src 'self' 'unsafe-inline'; img-src 'self' data:; font-src 'self' data:";
        private final ProjectProperties.Security.ClientAuthorization clientAuthorization = new ProjectProperties.Security.ClientAuthorization();
        private final ProjectProperties.Security.Authentication authentication = new ProjectProperties.Security.Authentication();
        private final ProjectProperties.Security.RememberMe rememberMe = new ProjectProperties.Security.RememberMe();
        private final ProjectProperties.Security.OAuth2 oauth2 = new ProjectProperties.Security.OAuth2();

        public Security() {
        }

        public ProjectProperties.Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public ProjectProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public ProjectProperties.Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }

        public ProjectProperties.Security.OAuth2 getOauth2() {
            return this.oauth2;
        }

        public String getContentSecurityPolicy() {
            return this.contentSecurityPolicy;
        }

        public void setContentSecurityPolicy(String contentSecurityPolicy) {
            this.contentSecurityPolicy = contentSecurityPolicy;
        }

        public static class OAuth2 {
            private List<String> audience = new ArrayList();

            public OAuth2() {
            }

            public List<String> getAudience() {
                return Collections.unmodifiableList(this.audience);
            }

            public void setAudience(@NotNull List<String> audience) {
                this.audience.addAll(audience);
            }
        }

        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = MyProjectDefaults.Security.RememberMe.key;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class Authentication {
            private final ProjectProperties.Security.Authentication.Jwt jwt = new ProjectProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public ProjectProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = MyProjectDefaults.Security.Authentication.Jwt.secret;
                    this.base64Secret = MyProjectDefaults.Security.Authentication.Jwt.base64Secret;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
                this.accessTokenUri = MyProjectDefaults.Security.ClientAuthorization.accessTokenUri;
                this.tokenServiceId = MyProjectDefaults.Security.ClientAuthorization.tokenServiceId;
                this.clientId = MyProjectDefaults.Security.ClientAuthorization.clientId;
                this.clientSecret = MyProjectDefaults.Security.ClientAuthorization.clientSecret;
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }
    }

    public static class Mail {
        private boolean enabled = false;
        private String from = "";
        private String baseUrl = "";

        public Mail() {
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Cache {
        private final ProjectProperties.Cache.Hazelcast hazelcast = new ProjectProperties.Cache.Hazelcast();
        private final ProjectProperties.Cache.Caffeine caffeine = new ProjectProperties.Cache.Caffeine();
        private final ProjectProperties.Cache.Ehcache ehcache = new ProjectProperties.Cache.Ehcache();
        private final ProjectProperties.Cache.Infinispan infinispan = new ProjectProperties.Cache.Infinispan();
        private final ProjectProperties.Cache.Memcached memcached = new ProjectProperties.Cache.Memcached();
        private final ProjectProperties.Cache.Redis redis = new ProjectProperties.Cache.Redis();

        public Cache() {
        }

        public ProjectProperties.Cache.Hazelcast getHazelcast() {
            return this.hazelcast;
        }

        public ProjectProperties.Cache.Caffeine getCaffeine() {
            return this.caffeine;
        }

        public ProjectProperties.Cache.Ehcache getEhcache() {
            return this.ehcache;
        }

        public ProjectProperties.Cache.Infinispan getInfinispan() {
            return this.infinispan;
        }

        public ProjectProperties.Cache.Memcached getMemcached() {
            return this.memcached;
        }

        public ProjectProperties.Cache.Redis getRedis() {
            return this.redis;
        }

        public static class Redis {
            private String[] server;
            private int expiration;
            private boolean cluster;
            private int connectionPoolSize;
            private int connectionMinimumIdleSize;
            private int subscriptionConnectionPoolSize;
            private int subscriptionConnectionMinimumIdleSize;

            public Redis() {
                this.server = MyProjectDefaults.Cache.Redis.server;
                this.expiration = 300;
                this.cluster = false;
                this.connectionPoolSize = 64;
                this.connectionMinimumIdleSize = 24;
                this.subscriptionConnectionPoolSize = 50;
                this.subscriptionConnectionMinimumIdleSize = 1;
            }

            public String[] getServer() {
                return this.server;
            }

            public void setServer(String[] server) {
                this.server = server;
            }

            public int getExpiration() {
                return this.expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isCluster() {
                return this.cluster;
            }

            public void setCluster(boolean cluster) {
                this.cluster = cluster;
            }

            public int getConnectionPoolSize() {
                return this.connectionPoolSize;
            }

            public ProjectProperties.Cache.Redis setConnectionPoolSize(int connectionPoolSize) {
                this.connectionPoolSize = connectionPoolSize;
                return this;
            }

            public int getConnectionMinimumIdleSize() {
                return this.connectionMinimumIdleSize;
            }

            public ProjectProperties.Cache.Redis setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
                this.connectionMinimumIdleSize = connectionMinimumIdleSize;
                return this;
            }

            public int getSubscriptionConnectionPoolSize() {
                return this.subscriptionConnectionPoolSize;
            }

            public ProjectProperties.Cache.Redis setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
                this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
                return this;
            }

            public int getSubscriptionConnectionMinimumIdleSize() {
                return this.subscriptionConnectionMinimumIdleSize;
            }

            public ProjectProperties.Cache.Redis setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
                this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
                return this;
            }
        }

        public static class Memcached {
            private boolean enabled = false;
            private String servers = "localhost:11211";
            private int expiration = 300;
            private boolean useBinaryProtocol = true;
            private ProjectProperties.Cache.Memcached.Authentication authentication = new ProjectProperties.Cache.Memcached.Authentication();

            public Memcached() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getServers() {
                return this.servers;
            }

            public void setServers(String servers) {
                this.servers = servers;
            }

            public int getExpiration() {
                return this.expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isUseBinaryProtocol() {
                return this.useBinaryProtocol;
            }

            public void setUseBinaryProtocol(boolean useBinaryProtocol) {
                this.useBinaryProtocol = useBinaryProtocol;
            }

            public ProjectProperties.Cache.Memcached.Authentication getAuthentication() {
                return this.authentication;
            }

            public static class Authentication {
                private boolean enabled = false;
                private String username;
                private String password;

                public Authentication() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public ProjectProperties.Cache.Memcached.Authentication setEnabled(boolean enabled) {
                    this.enabled = enabled;
                    return this;
                }

                public String getUsername() {
                    return this.username;
                }

                public ProjectProperties.Cache.Memcached.Authentication setUsername(String username) {
                    this.username = username;
                    return this;
                }

                public String getPassword() {
                    return this.password;
                }

                public ProjectProperties.Cache.Memcached.Authentication setPassword(String password) {
                    this.password = password;
                    return this;
                }
            }
        }

        public static class Infinispan {
            private String configFile = "default-configs/default-jgroups-tcp.xml";
            private boolean statsEnabled = false;
            private final ProjectProperties.Cache.Infinispan.Local local = new ProjectProperties.Cache.Infinispan.Local();
            private final ProjectProperties.Cache.Infinispan.Distributed distributed = new ProjectProperties.Cache.Infinispan.Distributed();
            private final ProjectProperties.Cache.Infinispan.Replicated replicated = new ProjectProperties.Cache.Infinispan.Replicated();

            public Infinispan() {
            }

            public String getConfigFile() {
                return this.configFile;
            }

            public void setConfigFile(String configFile) {
                this.configFile = configFile;
            }

            public boolean isStatsEnabled() {
                return this.statsEnabled;
            }

            public void setStatsEnabled(boolean statsEnabled) {
                this.statsEnabled = statsEnabled;
            }

            public ProjectProperties.Cache.Infinispan.Local getLocal() {
                return this.local;
            }

            public ProjectProperties.Cache.Infinispan.Distributed getDistributed() {
                return this.distributed;
            }

            public ProjectProperties.Cache.Infinispan.Replicated getReplicated() {
                return this.replicated;
            }

            public static class Replicated {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;

                public Replicated() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }
            }

            public static class Distributed {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;
                private int instanceCount = 1;

                public Distributed() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }

                public int getInstanceCount() {
                    return this.instanceCount;
                }

                public void setInstanceCount(int instanceCount) {
                    this.instanceCount = instanceCount;
                }
            }

            public static class Local {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;

                public Local() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }
            }
        }

        public static class Ehcache {
            private int timeToLiveSeconds = 3600;
            private long maxEntries = 100L;

            public Ehcache() {
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return this.maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Caffeine {
            private int timeToLiveSeconds = 3600;
            private long maxEntries = 100L;

            public Caffeine() {
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return this.maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Hazelcast {
            private int timeToLiveSeconds = 3600;
            private int backupCount = 1;

            public Hazelcast() {
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public int getBackupCount() {
                return this.backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }
        }
    }

    public static class Database {
        private final ProjectProperties.Database.Couchbase couchbase = new ProjectProperties.Database.Couchbase();

        public Database() {
        }

        public ProjectProperties.Database.Couchbase getCouchbase() {
            return this.couchbase;
        }

        public static class Couchbase {
            private String bucketName;

            public Couchbase() {
            }

            public String getBucketName() {
                return this.bucketName;
            }

            public ProjectProperties.Database.Couchbase setBucketName(String bucketName) {
                this.bucketName = bucketName;
                return this;
            }
        }
    }

    public static class Http {
        private final ProjectProperties.Http.Cache cache = new ProjectProperties.Http.Cache();

        public Http() {
        }

        public ProjectProperties.Http.Cache getCache() {
            return this.cache;
        }

        public static class Cache {
            private int timeToLiveInDays = 1461;

            public Cache() {
            }

            public int getTimeToLiveInDays() {
                return this.timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Async {
        private int corePoolSize = 2;
        private int maxPoolSize = 50;
        private int queueCapacity = 10000;

        public Async() {
        }

        public int getCorePoolSize() {
            return this.corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return this.maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return this.queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }
}

