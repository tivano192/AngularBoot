import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'findLanguageFromKey' })
export class FindLanguageFromKeyPipe implements PipeTransform {
  private languages: { [key: string]: { name: string; rtl?: boolean } } = {
    en: { name: 'English' },
    // myApplication-needle-i18n-language-key-pipe - myApplication will add/remove languages in this object
  };

  transform(lang: string): string {
    return this.languages[lang].name;
  }
}
