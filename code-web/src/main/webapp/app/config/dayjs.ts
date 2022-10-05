import * as dayjs from 'dayjs';
import * as customParseFormat from 'dayjs/plugin/customParseFormat';
import * as duration from 'dayjs/plugin/duration';
import * as relativeTime from 'dayjs/plugin/relativeTime';

// myApp-needle-i18n-language-dayjs-imports - Application will import languages from dayjs here
import 'dayjs/locale/en';

// DAYJS CONFIGURATION
dayjs.extend(customParseFormat);
dayjs.extend(duration);
dayjs.extend(relativeTime);
