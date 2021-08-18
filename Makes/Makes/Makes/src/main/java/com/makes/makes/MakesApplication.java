package com.makes.makes;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
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
//			BookCover bookCover1 = new BookCover("הדייג ואשתו","photo1.jpg");
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
//			coverRepository.insert(bookCover1);
//			Trepository.insert(bt1);
//
//		};
//	}

//@Bean
//CommandLineRunner runner(BookTemplateRepository Trepository,BookCoverRepository coverRepository) {
//
//	return args -> {
//		BookCover bookCover1 = new BookCover("סינדרלה","Sinderela.jpg");
//			BookCover bookCover2 = new BookCover("שילגיה","Shilgiya.jpeg");
//			BookCover bookCover3 = new BookCover("פיטר-פן","Piterpen.jpg");
//			BookCover bookCover4 = new BookCover("כיפה אדומה","KipaAduma.jfif");
//
//		coverRepository.insert(bookCover1);
//		coverRepository.insert(bookCover2);
//		coverRepository.insert(bookCover3);
//		coverRepository.insert(bookCover4);
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
