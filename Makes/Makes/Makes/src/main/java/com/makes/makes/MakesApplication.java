package com.makes.makes;

import java.util.*;

import com.makes.makes.model.*;
import com.makes.makes.repository.*;
import com.makes.makes.model.BookCover;
import com.makes.makes.model.Question;
import com.makes.makes.repository.BookCoverRepository;
// import com.makes.makes.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakesApplication.class, args);
	}

//
//	@Bean
//	CommandLineRunner runner(BookCoverRepository BCrepository, BookTemplateRepository BTrepository) {
//
//		return args -> {
//
//			BookCover bookCover = new BookCover("כיפה אדומה", "Sinderela.jpg",null);
//			BCrepository.insert(bookCover);
//
//			List<Page> pages = new ArrayList<Page>();
//			UUID u1 = UUID.randomUUID();
//			UUID u2 = UUID.randomUUID();
//			UUID u3o1 = UUID.randomUUID();
//			UUID u3o2 = UUID.randomUUID();
//			UUID u4o1 = UUID.randomUUID();
//			UUID u4o2 = UUID.randomUUID();
//			UUID[] uArr1 = {u2, null};
//			UUID[] uArr2 = {u3o1, u3o2};
//			UUID[] uArr3o1 = {u4o1, null};
//			UUID[] uArr3o2 = {u4o2, null};
//			UUID[] uArr4 = {null, null};
//
//			List<String> options = new ArrayList<String>();
//			options.add("כן");
//			options.add("לא");
//			TurningPoint turningPoint = new TurningPoint("האם כיפה אדומה שמה לב שזו לא סבתא?", options, 2);
//
//			Page p1 = new Page("פעם לפני שנים רבות בכפר אחד חיה ילדה קטנה, היפה ביותר שנראתה מעולם ושמה <שם>. אמה מאוד אהבה אותה, וסבתה אהבה אותה אפילו יותר. סבתא סרגה ל<שם> כיפה אדומה קטנה, שהלמה אותה כל כך עד שכולם קראו לה כיפה אדומה.\n" +
//					"יום אחד אמא של כיפה אדומה, שהכינה מעט <אוכל>, אמרה לה:\n" +
//					"\"לכי, יקירתי, וראי מה שלום סבתא, כי שמעתי שהיא חלתה מאוד. קחי בשבילה את ה<אוכל> הזה.\"\n" +
//					"כיפה אדומה יצאה מיד לביתה של סבתא.\n" +
//					"כשהלכה דרך היער, היא פגשה <אויב> זקן. הוא שאל לאן היא הולכת. כיפה אדומה המסכנה, שלא ידעה עד כמה מסוכן היה להישאר ולדבר עם ה<אויב>, אמרה לו:\n" +
//					"\"אני הולכת לראות את סבתא שלי ולתת לה <אוכל>\"\n" +
//					"\"היא גרה רחוק?\" שאל ה<אויב>.\n" +
//					"\"הו, כן\" ענתה כיפה אדומה \"זה מעבר לטחנת הרוח שאתה רואה שם, בבית הראשון בכפר.\"\n", "Sinderela.jpg", false, null, u1, uArr1, null, 1);
//			Page p2 = new Page("כיפה אדומה נפרדה מה<אויב> והחלה ללכת אל סבתא דרך השביל. ה<אויב> החל לרוץ מהר ככל שיכל לביתה של הסבתא בקיצור דרך שהכיר ביער. בזמן שכיפה אדומה <תחביב> בדרך לסבתא, ה<אויב> הגיע לביתה של סבתא ונקש על הדלת -- טוק טוק.\n" +
//					"\"מי שם?\"\n" +
//					"\"נכדתך, כיפה אדומה\" ענה ה<אויב>, מחקה את קולה של כיפה אדומה, \"הבאתי לך <אוכל> ששלחה לך אמא.\"\n" +
//					"הסבתא שהייתה במיטה, קראה:\n" +
//					"\"פתחי את הדלת נכדתי.\"\n" +
//					"ה<אויב > פתח את הדלת, והתנפל על סבתא ואכל אותה ברגע. ה<אויב> לקח לסבתא את הבגדים ונכנס למיטתה וחיכה לכיפה אדומה. \n" +
//					"טוק טוק. נשמעה דפיקה על הדלת.\n" +
//					"\"מי שם?\" ענה ה<אויב>\n" +
//					"כיפה אדומה ענתה:\n" +
//					"\"זו נכדתך, כיפה אדומה, שהביאה לך <אוכל> שאמא שלחה לך.\"\n" +
//					"ה<אויב> קרא אליה, כשהוא מרכך את קולו ככל שיכל:\n" +
//					"\"פתחי את הדלת נכדתי.\"\n" +
//					"ה<אויב>, שראה אותה נכנסת, אמר לה, כשהוא מתחבא מתחת לשמיכה:\n" +
//					"\"שימי את ה<אוכל> על השרפרף, ובואי שבי לידי\"\n", "Sinderela.jpg", true, turningPoint, u2, uArr2, u1, 2);
//			Page p3o1 = new Page("כיפה אדומה שראתה את הידיים והרגליים הגדולות והפרוותיות של סבתא, את האוזניים הגדולות שלה, את העיניים הגדולות שלה, ואת השיניים הגדולות של סבתא, הבינה שזו לא סבתא שיושבת במיטה. \n" +
//					"מהר קמה כיפה אדומה ורצה חזרה לכיוון היער במהירות האפשרית.\n" +
//					"בעודה בורחת מה<אויב>, נתקלה כיפה אדומה בצייד וסיפרה לו את כל שקרה.\n", "Sinderela.jpg", false, null, u3o1, uArr3o1, u2, 3);
//			Page p3o2 = new Page("כיפה אדומה התיישבה ליד סבתא ונדהמה:\n" +
//					"\"סבתא, אילו ידיים גדולות יש לך!\"\n" +
//					"\"כדי שאוכל לחבק אותך טוב יותר, יקירתי\"\n" +
//					"\"סבתא, אילו רגליים גדולות יש לך!\"\n" +
//					"\"כדי שאוכל לרוץ טוב יותר, ילדתי\"\n" +
//					"\"סבתא, אילו אוזניים גדולות יש לך!\"\n" +
//					"\"כדי שאוכל לשמוע אותך טוב יותר ילדתי\"\n" +
//					"\"סבתא, איזה עיניים גדולות יש לך!\"\n" +
//					"\"כדי שאוכל לראות אותך טוב יותר ילדתי\"\n" +
//					"\"סבתא, איזה שיניים גדולות יש לך!\"\n" +
//					"\"זה כדי שאוכל לאכול אותך.\"\n" +
//					"ובאומרו זאת, ה<אויב> הרשע התנפל על כיפה אדומה, ואכל את כולה.\n", "Sinderela.jpg", false, null, u3o2, uArr3o2, u2, 3);
//			Page p4o1 = new Page("נכנסו כיפה אדומה והצייד לבית של סבתא, שם ראו את ה<אויב> נאבק לצאת מהבגדים של סבתא ולברוח, הצייד נתן ל<אויב> מכה בראש, והוא התעלף. הצייד הוציא סכין חדה מכיסו, פתח את את בטן ה<אויב> ומהבטן יצאה סבתא והנה - בריאה ושלמה.\n" +
//					"הצייד אסף מהר אבנים, מילא בהן את בטן ה<אויב>, בלי להעיר אותו, ותפר את החתך. כשה<אויב> התעורר וראה את הצייד, סבתא וכיפה אדומה, קפץ מהמיטה והתחיל לברוח.\n" +
//					"הוא רץ עד שהגיע לנהר. הוא היה צמא מאוד ורצה לשתות מים, אך האבנים שבבטן משכו אותו מהגדה והוא נפל לתוך הנהר. הזרם סחף אותו רחוק, רחוק מהיער. לא ידוע מה קרה ל<אויב>, אך הוא לא חזר ליער לעולם.\n" +
//					"כיפה אדומה , סבתא שלה והצייד אכלו את ה<אוכל> ושתו מיץ. כיפה אדומה הבטיחה שלהבא לא תסטה מהשביל לסבתא, ושלא תדבר בדרך עם חיות ואנשים שאינה מכירה.\n", "Sinderela.jpg", false, null, u4o1, uArr4, u3o1, 4);
//			Page p4o2 = new Page("אחרי הארוחה הדשנה הזו נשכב ה<אויב> שוב במיטה ונרדם. אבל תוך כדי שינה התחיל לנחור חזק, עד שקולות הנחירה נשמעו בכל היער.\n" +
//					"לא הרחק מביתה של סבתא, עבר הצייד. \"מה קרה לה?\" חשב \"למה סבתא נוחרת כל כך חזק. אולי היא חולה?\" והוא נכנס לבית של סבתא כדי לבדוק.\n" +
//					"כשראה את ה<אויב> הרע שוכב במיטה ונוחר, הוציא סכין חדה מכיסו, פתח את בטן ה<אויב> ומהבטן יצאו סבתא וכיפה אדומה, והנה – בריאות ושלמות.\n" +
//					"הצייד אסף מהר אבנים, מילא בהן את בטן ה<אויב>, בלי להעיר אותו, ותפר את החתך. כשה<אויב> התעורר וראה את הצייד, סבתא וכיפה אדומה, קפץ מהמיטה והתחיל לברוח.\n" +
//					"הוא רץ עד שהגיע לנהר. הוא היה צמא מאוד ורצה לשתות מים, אך האבנים שבבטן משכו אותו מהגדה והוא נפל לתוך הנהר. הזרם סחף אותו רחוק, רחוק מהיער. לא ידוע מה קרה ל<אויב>, אך הוא לא חזר ליער לעולם.\n" +
//					"כיפה אדומה , סבתא שלה והצייד אכלו את ה<אוכל> ושתו מיץ. כיפה אדומה הבטיחה שלהבא לא תסטה מהשביל לסבתא, ושלא תדבר בדרך עם חיות ואנשים שאינה מכירה.\n", "Sinderela.jpg", false, null, u4o2, uArr4, u3o2, 4);
//
//			pages.add(p1);
//			pages.add(p2);
//			pages.add(p3o1);
//			pages.add(p3o2);
//			pages.add(p4o1);
//			pages.add(p4o2);
//
//			List<Question> questions = new ArrayList<Question>();
//			Question q1 = new Question("input", "?מה שם הילדה", null, "שם");
//			Question q2 = new Question("input", "מה הביאה הילדה לסבתא לאכול?", null, "אוכל");
//			Question q3 = new Question("input", "את מי פגשה הילדה בדרך?", null, "אויב");
//			List<String> hobby = new ArrayList<String>();
//			hobby.add("קטפה פרחים");
//			hobby.add("רקדה");
//			hobby.add("שרה");
//			hobby.add("שיחקה עם חיות היער");
//			Question q4 = new Question("combo", "מה הילדה עשתה בדרך לסבתא?", hobby, "תחביב");
//
//			questions.add(q1);
//			questions.add(q2);
//			questions.add(q3);
//			questions.add(q4);
//
//			Map<String,String> defaultLabelInText = new HashMap<String, String>();
//			defaultLabelInText.put("שם","כיפה אדומה");
//			defaultLabelInText.put("אוכל","מרק");
//			defaultLabelInText.put("אויב","זאב");
//			defaultLabelInText.put("תחביב","קטפה פרחים");
//
//			BookTemplate bt1 = new BookTemplate("כיפה אדומה", pages, questions, bookCover.getId(),defaultLabelInText);
//
//			BTrepository.insert(bt1);
//
//		};
//	}
//
//	@Bean
//	CommandLineRunner runner(BookTemplateRepository Trepository,BookCoverRepository coverRepository) {
//
//		return args -> {
//
//			List<Page> pages = new ArrayList<Page>();
//			UUID u1 = UUID.randomUUID();
//			UUID u2 = UUID.randomUUID();
//			UUID u3 = UUID.randomUUID();
//			UUID u4 = UUID.randomUUID();
//			UUID u5o1 = UUID.randomUUID();
//			UUID u5o2 = UUID.randomUUID();
//			UUID[] uArr1 = {u2, null};
//			UUID[] uArr2 = {u3, null};
//			UUID[] uArr3 = {u4, null};
//			UUID[] uArr4 = {u5o1, u5o2};
//			UUID[] uArr5o1 = {null, null};
//			UUID[] uArr5o2 = {null, null};
//
//			BookCover bookCover1 = new BookCover("הדייג ואשתו","photo1.jpg",null);
//	        coverRepository.insert(bookCover1);
//
//			List<String> options = new ArrayList<String>();
//			options.add("כן");
//			options.add("לא");
//			TurningPoint turningPoint = new TurningPoint("האם אשתו של הדייג מרוצה?", options, 2);
//
//			Page p1 = new Page("לפני שנים רבות גרו בבקתה דלה, על חופו של ים המים, דייג עני ושמו <שם> עם אשתו הענייה. כל בוקר היה הדייג יורד אל חוף הים, פורש את הרשת – ונפשו מבקשת:\n" +
//					"מה קשים הם חיי הדייג; יום ולילה רק ידאג. מי ייתן ויזרח לי יום חג ואצליח לדוג סוף סוף דג.\n" +
//					"והנה, יום אחד נתמלאה תפילתו של הדייג כאשר העלה הדייג את הרשת והציץ אל תוכה, ראה <יצור_ימי> זהב!  ביקש הדייג לקחת את <יצור_ימי> הזהב לביתו, אך פתאום פתח ה<יצור_ימי> את פיו ואמר:\n" +
//					"אנא, דייג טוב עיניים,\n" +
//					"החזר נא אותי אל המים.\n" +
//					"אם זאת תעשה וחסדך תגלה –\n" +
//					"כל אשר תבקש – אמלא!\n" +
//					"הקשיב הדייג לבקשתו של ה<יצור_ימי> ולא ידע מה לעשות: <יצור_ימי> זהב נפלא כל כך! חבל לוותר עליו. אך מאחר שהיה אדם טוב לב, הוציא לבסוף את ה<יצור_ימי> מתוך הרשת, החזירו למים ולא ביקש דבר.\n" +
//					"ובפתח הבקתה ישבה אשת הדייג וחיכתה לבעלה, כי ישוב מן הים.  \n", "Sinderela.jpg", false, null, u1, uArr1, null,1);
//			Page p2 = new Page("והנה הופיע הדייג, הרשת ריקה, ובפיו הסיפור:\n" +
//					"<יצור_ימי> זהב העליתי, אך הוא ביקש כי אחזירו למים, והבטיח כי ימלא כל אשר אבקש ממנו.\n" +
//					"ומה ביקשת ממנו?\n" +
//					"דבר לא ביקשתי, אמר הדייג.\n" +
//					"למשמע הדברים האלה נתמלא לבה של האישה זעם והיא קראה:\n" +
//					"אבוי, איזה בעל תמים. התבונן ותראה איך אנחנו גרים – בבקתה עלובה, המלאה עכברים. שוב לים ואמור ל<יצור_ימי> בזה הלשון: אשתי מבקשת לגור ב<בית>\n" +
//					"מה… נבהל הדייג, אבל…\n" +
//					"הרם רגליך! צוותה האישה על בעלה בקול צעקה.\n", "Sinderela.jpg", false, null, u2, uArr2, u1,3);
//			Page p3 = new Page("מה יכול היה הדייג המסכן לעשות? הסתובב וחזר אל החוף. הגיע לים וקרא בקול:\n" +
//					"<יצור_ימי> זהב, <יצור_ימי> פלאים אנא בוא אלי, ידידי הנעים.\n" +
//					"לא עבר רגע והנה נראה ראשו של ה<יצור_ימי> מציץ מן המים ופונה אל הדייג בקול פעמונים:\n" +
//					"הנני, דייג טוב עיניים, שמעתי קולך על המים. אם תרצה משהו – לי גלה: כל אשר תבקש – אמלא.\n" +
//					"אני איני מבקש דבר, אמר הדייג, אבל אשתי – היא כועסת עלי ורותחת. אותי מגרשת, הימה שולחת. אנא סלח לה. אך בפיה כזה מין פזמון היא מבקשת לגור ב…<בית>.\n" +
//					"רגע קט שררה דממה על החוף ואחר כך נשמע קולו של ה<יצור_ימי>.\n" +
//					"לך לשלום, ידידי הדייג. בקשת אשתך תתמלא במהרה!\n" +
//					"שב הדייג לביתו, ולפתע נעצר במקומו. במקום אשר בו עמדה הבקתה העלובה ראה <בית> רב פאר ונוצץ בשמש. ובפתח ה<בית> ישבה אשתו לבושה שמלה הדורה.\n" +
//					"ובכן, רעיתי, האם עכשיו מרוצה את? פנה אליה הדייג.\n" +
//					"מרוצה? לא ולא! אם בקשת <בית> – באותה הדקה גם יכולת לדרוש <משאלה_שניה>. לך ל<יצור_ימי> ובקש שייתן לי גם <משאלה_שניה> וכל היתר.\n", "Sinderela.jpg", false, null, u3, uArr3, u2, 2);
//			Page p4 = new Page("מה יכול היה הדייג לעשות? הסתובב לאחור ועלה על השביל המוליך אל הים. בא הדייג לחוף, נכנס לים, עלה על סלע וקרא:\n" +
//					"<יצור_ימי> זהב, <יצור_ימי> פלאים, אנא, בוא אלי!\n" +
//					"לא עבר רגע והנה נראה ראשו של ה<יצור_ימי> מציץ מעל המים. והדייג פתח ואמר בקול, שיש בו בושה ותחינה:\n" +
//					"אשתי – אנא סלח לה… אבל דעתה נסתלקה: מבקשת הוא <משאלה_שניה>.\n" +
//					"אחר כך נשמע קולו של <יצור_ימי> הזהב:\n" +
//					"שמעתי, הבנתי – ואל תתפלא: בקשת אשתך חיש מהר תתמלא.\n" +
//					"עלה הדייג בשביל, ולסו ל<בית> ראה את אשתו יושבת ולה <משאלה_שניה>.\n" +
//					"ובכן, רעיתי, האם עכשיו את מרוצה? אמר לה הדייג.\n", "Sinderela.jpg", true, turningPoint, u4, uArr4, u3,4);
//			Page p5o1 = new Page("אשתו ענתה: כן בעלי האהוב, כל מה שרציתי קיבלתי, עכשיו אני מאושרת, בוא שב עימי ותהנה איתי מהשקיעה\n" +
//					"ישב הדייג עם אשתו, נהנו מהשקיעה וחיו בעושר ואושר עד היום הזה \n", "Sinderela.jpg", false, null, u5o1, uArr5o1, u4,5);
//			Page p5o2 = new Page("אך אשתו ענתה בקול נרגז:\n" +
//					"עד מתי תרוץ כל פעם לבקש? לך, תפוס את ה<יצור_ימי>, תשים אותו בכד – וכל דבר שנבקש – הוא יעשה מייד!\n" +
//					"הלך הדייג לשפת הים, כמו שצוותה אשתו, אבל ה<יצור_ימי> לא בא כלל. פשוט צלל ונעלם.\n" +
//					"חזר הדייג אל ביתו ומה ראה? במקום <בית> – רק בית דל וגג דולף. הכל כבתחילה. ובפתח עומדת אשתו בשמלה ישנה, והיא בוכייה. ומאותו יום למדו הדייג ואשתו – הרוצה הכול – מחמיץ הכול!\n",
//					"Sinderela.jpg", false, null, u5o2, uArr5o2, u4,5);
//
//			pages.add(p1);
//			pages.add(p2);
//			pages.add(p3);
//			pages.add(p4);
//			pages.add(p5o1);
//			pages.add(p5o2);
//
//			List<Question> questions = new ArrayList<Question>();
//			Question q1 = new Question("input", "?מה שם הילד", null, "שם");
//			List<String> seaCreature = new ArrayList<String>();
//			seaCreature.add("דג");
//			seaCreature.add("תמנון");
//			seaCreature.add("כוכב ים");
//			seaCreature.add("דולפין");
//			Question q2 = new Question("combo", "איזו חיה יתפוס הדייג", seaCreature, "יצור_ימי");
//			List<String> house = new ArrayList<String>();
//			house.add("וילה");
//			house.add("ארמון");
//			house.add("אחוזה");
//			house.add("טירה");
//			Question q3 = new Question("combo", "מהו בית החלומות?", house, "בית");
//			Question q4 = new Question("input", "מה תהיה המשאלה השניה?", null, "משאלה_שניה");
//
//			questions.add(q1);
//			questions.add(q2);
//			questions.add(q3);
//			questions.add(q4);
//
//
//			BookTemplate bt1 = new BookTemplate("הדייג ואשתו", pages, questions, bookCover1.getId());
//
//
//			Trepository.insert(bt1);
//
//		};
//	}
//
//@Bean
//CommandLineRunner runner(BookTemplateRepository Trepository,BookCoverRepository coverRepository) {
//
//	return args -> {
//		BookCover bookCover1 = new BookCover("סינדרלה","Sinderela.jpg",null);
//			BookCover bookCover2 = new BookCover("שילגיה","Shilgiya.jpeg",null);
//			BookCover bookCover3 = new BookCover("פיטר-פן","Piterpen.jpg",null);
////			BookCover bookCover4 = new BookCover("כיפה אדומה","KipaAduma.jfif");
//
//		coverRepository.insert(bookCover1);
//		coverRepository.insert(bookCover2);
//		coverRepository.insert(bookCover3);
////		coverRepository.insert(bookCover4);
//
//		List<Page> pages = new ArrayList<Page>();
//		UUID u1 = UUID.randomUUID();
//		UUID u2 = UUID.randomUUID();
//		UUID[] uArr1 = {u2, null};
//		UUID[] uArr2 = {null, null};
//		Page p1 = new Page(" <PRINCE> הלכה לנשף עם <NAME>", "Sinderela.jpg", false, null, u1, uArr1, null,1);
//		Page p2 = new Page(" התאהבו וחיו באושר ועושר <PRINCE>ו <NAME>", "Sinderela.jpg", false, null, u2, uArr2, u1,2);
//		pages.add(p1);
//		pages.add(p2);
//
//
//		List<Question> questions = new ArrayList<Question>();
//		Question q1 = new Question("input", "?מה שם הילדה", null, "NAME");
//		List<String> princes = new ArrayList<String>();
//		princes.add("ניר");
//		princes.add("סהר");
//		princes.add("אלמוג");
//		princes.add("רועי");
//		Question q2 = new Question("combo", "?שם הנסיך", princes, "PRINCE");
//		questions.add(q1);
//		questions.add(q2);
//
//
//		BookTemplate bt1 = new BookTemplate("סינדרלה", pages, questions, bookCover1.getId());
//
//		Trepository.insert(bt1);
//
//
//
//
//	};
//}
}
