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

	// @Bean
	// CommandLineRunner runner(BookTemplateRepository BTRepository, BookCoverRepository BCRepository) {

	// 	return args -> {

	// 		BookCover bookCover = new BookCover("ג'ק ואפון הפלא", "Sinderela.jpg", null);
	// 		BCRepository.insert(bookCover);

	// 		List<Page> pages = new ArrayList<Page>();
	// 		UUID u1 = UUID.randomUUID();
	// 		UUID u2 = UUID.randomUUID();
	// 		UUID u3 = UUID.randomUUID();
	// 		UUID u4 = UUID.randomUUID();
	// 		UUID u5o1 = UUID.randomUUID();
	// 		UUID u5o2 = UUID.randomUUID();
	// 		UUID[] uArr1 = {u2, null};
	// 		UUID[] uArr2 = {u3, null};
	// 		UUID[] uArr3 = {u4, null};
	// 		UUID[] uArr4 = {u5o1, u5o2};
	// 		UUID[] uArr5o1 = {null, null};
	// 		UUID[] uArr5o2 = {null, null};

	// 		List<String> options = new ArrayList<String>();
	// 		options.add("כן");
	// 		options.add("לא");
	// 		TurningPoint turningPoint = new TurningPoint("האם הם ייתפסו?", options, 2);

	// 		Page p1 = new Page("<שם> ואמא שלו היו עניים מרודים וגרו בביקתה קטנה כשכל רכושם הוא <חיה> . יום אחד ראתה אמו של <שם> שאין להם כסף אפילו לאכול, ולכן ביקשה בצער רב מ<שם> שילך לשוק בעיר ושימכור את <חיה>.\n" +
	// 				"<שם> יצא בדרכו לשוק, מוליך את ה<חיה> בחבל ושורק לעצמו מנגינות עליזות. בדרך פגש איש זקן. ״שלום בחור צעיר״, אמר לו הזקן, ״אני רואה שיש לך פה <חיה> יפה. לאן אתה הולך?״\n" +
	// 				"״לשוק בעיר״, ענה <שם>, ״למכור את ה<חיה>״.\n" +
	// 				"״אה, למכור…״ אמר הזקן, ״אם כך יש לי פה משהו מיוחד מאוד בשבילך״. הוא פתח את ידו השמאלית והראה ל<שם> שלוש אפונים קטנות. ״אלו לא סתם אפונים – אלו אפוני קסם. אם תיתן לי את ה<חיה> בתמורה אביא לך את אפוני הקסם האלה.״\n" +
	// 				"<שם> התלהב מהעיסקה הטובה הזאת והסכים מיד. הוא מסר לזקן את ה<חיה> ולקח את האפונים. וכך כשהאפונים בידיו הוא חזר הביתה שמח על מזלו הטוב.\n", "Sinderela.jpg", false, null, u1, uArr1, null, 1);
	// 		Page p2 = new Page("אמו ראתה שהוא חזר בלי ה<חיה> וקיבלה את פניו בשמחה. ״מכרת את ה<חיה>?״ היא שאלה.\n" +
	// 				"״כן״, ענה לה <שם>.\n" +
	// 				"״וכמה קיבלת ? מטבע זהב? שני מטבעות?״\n" +
	// 				"״יותר טוב מכך!״ קרא <שם>, והראה לאמו את שלושת האפונים, ״אלו אפוני פלא!״\n" +
	// 				"״אוי, <שם>…״, אמרה אמו בצער. היא לקחה את האפונים מידו והשליכה אותן מחוץ לחלון. ״איך אתה נותן לרמות אותך כל-כך בקלות…״\n" +
	// 				"<שם> ואמו נאלצו ללכת לישון רעבים באותו לילה מכיוון שנותרו ללא כסף לאוכל. בבוקר פתח <שם> את חלון חדרו – ולתדהמתו ראה שיח אפונים ענק צומח מהמקום אליו זרקה אמו את אפוני הקסם. השיח התנשא לגובה רב, עובר את גג הבית ומטפס למעלה עד שהגיע לעננים.\n" +
	// 				"<שם> רץ החוצה והחל לטפס על השיח, סקרן לראות מה יש בקצהו. הוא טיפס עוד ועוד עד שהבית נראה קטן כמו קובית לגו והאנשים על האדמה נראו כמו נמלים. הוא המשיך לטפס עד שהגיע לענן גדול. כשהמשיך לטפס הוא גילה שקצה שיח האפונים מגיע לשער טירה עצומה שיושבת על הענן.\n", "Sinderela.jpg", false, null, u2, uArr2, u1, 2);
	// 		Page p3 = new Page("<שם> טיפס על הענן וניגש לשער הטירה. הוא עבר אותו ומצא עצמו בתוך חדר ענק, עם שולחן ענק וכסא ענק. בקצה החדר, על הרצפה, ראה <שם> כלוב זהב ובתוכו תרנגולת. כשהיא ראתה את <שם> היא קראה לעברו בקול: ״בבקשה תוציא אותי מפה! אני תרנגולת קסומה שמטילה ביצי זהב – כדאי לך לקחת אותי איתך!״.\n" +
	// 				"<שם> ניגש לכלוב, פתח אותו ואסף את התרנגולת אל מתחת זרועו. לפתע הוא הרגיש את האדמה רועדת. <שם> רץ לרגלו של השולחן הענקי והסתתר מאחוריה, ברגע בו <יצור_ענק> מפלצתי נכנס לחדר.\n" +
	// 				"ה<יצור_ענק> היה בגובה של 3 בני אדם ואחז בידו מקל גדול. עיניו היו אדומות ושיניו חדות. <שם> נשם בשקט, מקווה שהיצור לא יראה אותו. לפתע ה<שם> רחרח את האוויר וקרא בקול שהתגלגל מקצה אחד של החדר לקצה השני:\n" +
	// 				"פי פה פו פם\n" +
	// 				"אני מריח ריח אדם,\n" +
	// 				"חי או מת – זאת כבר אדע\n" +
	// 				"אכין ממנו סעודה!\n" +
	// 				"הוא רחרח שוב את האוויר – ופנה לכיוון <שם>, חיוך רעב על פניו.\n", "Sinderela.jpg", false, null, u3, uArr3, u2, 3);
	// 		Page p4 = new Page("<שם> החל לרוץ, התרנגולת תחת זרועו. הוא רץ לאורך החדר, מרגיש את האדמה רועדת כשה<יצור_ענק> החל ללכת אחריו. הוא רץ דרך הדלת אל מחוץ לטירה, ואז תפס את שיח האפונה והחל לרדת במהירות. הוא ירד מהר ככל שיכול עד שהגיע לאדמה. כשהרים את ראשו הוא יכול היה לראות את ה<יצור_ענק> מעליו במרחק מטפס אט-אט למטה.", "Sinderela.jpg", true, turningPoint, u4, uArr4, u3, 4);
	// 		Page p5o1 = new Page("חיש מהר ירד ה<יצור_ענק> מהשיח ותפס את <שם> והתרנגולת הקסומה, ולקח אותם לביתו שבעננים.\n" +
	// 				"<שם> חיכה שירד הערב, וה<יצור_ענק> יירדם, והרג את ה<יצור_ענק> בעזרת חבל ענק, והוא גר בביתו הענק עם התרנגולת הקסומה ואימו מאז. \n", "Sinderela.jpg", false, null, u5o1, uArr5o1, u4, 5);
	// 		Page p5o2 = new Page("מיד רץ <שם> לתוך ביתו ויצא אוחז בגרזן. הוא הניף אותו וחבט בשיח האפונים. שוב ושוב הוא הכה בשיח, עד שקול אדיר נשמע כשהשיח נשבר ונפל – ויחד איתו נפל ה<יצור_ענק> מגובה אדיר. האדמה רעדה כשהענק פגע בה, והוא מת במקום.\n" +
	// 				"כשאמו של <שם> הגיעה הביתה הראה לה <שם> את התרנגולת הקסומה, והם מכרו את ביצי הזהב והפכו לעשירים. מאז לא חסר להם כלום, והם חיים בעושר ואושר עד עצם היום הזה.\n", "Sinderela.jpg", false, null, u5o2, uArr5o2, u4, 5);

	// 		pages.add(p1);
	// 		pages.add(p2);
	// 		pages.add(p3);
	// 		pages.add(p4);
	// 		pages.add(p5o1);
	// 		pages.add(p5o2);

	// 		List<Question> questions = new ArrayList<Question>();
	// 		Question q1 = new Question("input", "מה שם הילד?", null, "שם");
	// 		Question q2 = new Question("input", "איזו חיה מגדל הילד?", null, "חיה");
	// 		List<String> giantCreature = new ArrayList<String>();
	// 		giantCreature.add("ענק");
	// 		giantCreature.add("ציקלופ");
	// 		giantCreature.add("דרקון");
	// 		giantCreature.add("מפלץ");
	// 		Question q3 = new Question("combo", "איזה יצור יפגוש הילד?", giantCreature, "יצור_ענק");

	// 		questions.add(q1);
	// 		questions.add(q2);
	// 		questions.add(q3);

	// 		Map<String, String> defaultAnswers = new HashMap<String, String>();
	// 		defaultAnswers.put("שם", "ג'ק");
	// 		defaultAnswers.put("חיה", "כבשה");
	// 		defaultAnswers.put("יצור_ענק", "ענק");

	// 		BookTemplate bt1 = new BookTemplate("ג'ק ואפון הפלא", pages, questions, bookCover.getId(), defaultAnswers);

	// 		BTRepository.insert(bt1);

	// 	};
	// }
}


	// @Bean
	// CommandLineRunner runner(BookCoverRepository BCrepository, BookTemplateRepository BTrepository) {

	// 	return args -> {

	// 		BookCover bookCover = new BookCover("כיפה אדומה", "kipa/main.jpg",null);
	// 		BCrepository.insert(bookCover);

	// 		List<Page> pages = new ArrayList<Page>();
	// 		UUID u1 = UUID.randomUUID();
	// 		UUID u2 = UUID.randomUUID();
	// 		UUID u3o1 = UUID.randomUUID();
	// 		UUID u3o2 = UUID.randomUUID();
	// 		UUID u4o1 = UUID.randomUUID();
	// 		UUID u4o2 = UUID.randomUUID();
	// 		UUID[] uArr1 = {u2, null};
	// 		UUID[] uArr2 = {u3o1, u3o2};
	// 		UUID[] uArr3o1 = {u4o1, null};
	// 		UUID[] uArr3o2 = {u4o2, null};
	// 		UUID[] uArr4 = {null, null};

	// 		List<String> options = new ArrayList<String>();
	// 		options.add("כן");
	// 		options.add("לא");
	// 		TurningPoint turningPoint = new TurningPoint("האם כיפה אדומה שמה לב שזו לא סבתא?", options, 2);

	// 		Page p1 = new Page("פעם לפני שנים רבות בכפר אחד חיה ילדה קטנה, היפה ביותר שנראתה מעולם ושמה <שם>. אמה מאוד אהבה אותה, וסבתה אהבה אותה אפילו יותר. סבתא סרגה ל<שם> כיפה אדומה קטנה, שהלמה אותה כל כך עד שכולם קראו לה כיפה אדומה.\n" +
	// 				"יום אחד אמא של כיפה אדומה, שהכינה מעט <אוכל>, אמרה לה:\n" +
	// 				"\"לכי, יקירתי, וראי מה שלום סבתא, כי שמעתי שהיא חלתה מאוד. קחי בשבילה את ה<אוכל> הזה.\"\n" +
	// 				"כיפה אדומה יצאה מיד לביתה של סבתא.\n" +
	// 				"כשהלכה דרך היער, היא פגשה <אויב> זקן. הוא שאל לאן היא הולכת. כיפה אדומה המסכנה, שלא ידעה עד כמה מסוכן היה להישאר ולדבר עם ה<אויב>, אמרה לו:\n" +
	// 				"\"אני הולכת לראות את סבתא שלי ולתת לה <אוכל>\"\n" +
	// 				"\"היא גרה רחוק?\" שאל ה<אויב>.\n" +
	// 				"\"הו, כן\" ענתה כיפה אדומה \"זה מעבר לטחנת הרוח שאתה רואה שם, בבית הראשון בכפר.\"\n", "Sinderela.jpg", false, null, u1, uArr1, null, 1);
	// 		Page p2 = new Page("כיפה אדומה נפרדה מה<אויב> והחלה ללכת אל סבתא דרך השביל. ה<אויב> החל לרוץ מהר ככל שיכל לביתה של הסבתא בקיצור דרך שהכיר ביער. בזמן שכיפה אדומה <תחביב> בדרך לסבתא, ה<אויב> הגיע לביתה של סבתא ונקש על הדלת -- טוק טוק.\n" +
	// 				"\"מי שם?\"\n" +
	// 				"\"נכדתך, כיפה אדומה\" ענה ה<אויב>, מחקה את קולה של כיפה אדומה, \"הבאתי לך <אוכל> ששלחה לך אמא.\"\n" +
	// 				"הסבתא שהייתה במיטה, קראה:\n" +
	// 				"\"פתחי את הדלת נכדתי.\"\n" +
	// 				"ה<אויב > פתח את הדלת, והתנפל על סבתא ואכל אותה ברגע. ה<אויב> לקח לסבתא את הבגדים ונכנס למיטתה וחיכה לכיפה אדומה. \n" +
	// 				"טוק טוק. נשמעה דפיקה על הדלת.\n" +
	// 				"\"מי שם?\" ענה ה<אויב>\n" +
	// 				"כיפה אדומה ענתה:\n" +
	// 				"\"זו נכדתך, כיפה אדומה, שהביאה לך <אוכל> שאמא שלחה לך.\"\n" +
	// 				"ה<אויב> קרא אליה, כשהוא מרכך את קולו ככל שיכל:\n" +
	// 				"\"פתחי את הדלת נכדתי.\"\n" +
	// 				"ה<אויב>, שראה אותה נכנסת, אמר לה, כשהוא מתחבא מתחת לשמיכה:\n" +
	// 				"\"שימי את ה<אוכל> על השרפרף, ובואי שבי לידי\"\n", "Sinderela.jpg", true, turningPoint, u2, uArr2, u1, 2);
	// 		Page p3o1 = new Page("כיפה אדומה שראתה את הידיים והרגליים הגדולות והפרוותיות של סבתא, את האוזניים הגדולות שלה, את העיניים הגדולות שלה, ואת השיניים הגדולות של סבתא, הבינה שזו לא סבתא שיושבת במיטה. \n" +
	// 				"מהר קמה כיפה אדומה ורצה חזרה לכיוון היער במהירות האפשרית.\n" +
	// 				"בעודה בורחת מה<אויב>, נתקלה כיפה אדומה בצייד וסיפרה לו את כל שקרה.\n", "Sinderela.jpg", false, null, u3o1, uArr3o1, u2, 3);
	// 		Page p3o2 = new Page("כיפה אדומה התיישבה ליד סבתא ונדהמה:\n" +
	// 				"\"סבתא, אילו ידיים גדולות יש לך!\"\n" +
	// 				"\"כדי שאוכל לחבק אותך טוב יותר, יקירתי\"\n" +
	// 				"\"סבתא, אילו רגליים גדולות יש לך!\"\n" +
	// 				"\"כדי שאוכל לרוץ טוב יותר, ילדתי\"\n" +
	// 				"\"סבתא, אילו אוזניים גדולות יש לך!\"\n" +
	// 				"\"כדי שאוכל לשמוע אותך טוב יותר ילדתי\"\n" +
	// 				"\"סבתא, איזה עיניים גדולות יש לך!\"\n" +
	// 				"\"כדי שאוכל לראות אותך טוב יותר ילדתי\"\n" +
	// 				"\"סבתא, איזה שיניים גדולות יש לך!\"\n" +
	// 				"\"זה כדי שאוכל לאכול אותך.\"\n" +
	// 				"ובאומרו זאת, ה<אויב> הרשע התנפל על כיפה אדומה, ואכל את כולה.\n", "Sinderela.jpg", false, null, u3o2, uArr3o2, u2, 3);
	// 		Page p4o1 = new Page("נכנסו כיפה אדומה והצייד לבית של סבתא, שם ראו את ה<אויב> נאבק לצאת מהבגדים של סבתא ולברוח, הצייד נתן ל<אויב> מכה בראש, והוא התעלף. הצייד הוציא סכין חדה מכיסו, פתח את את בטן ה<אויב> ומהבטן יצאה סבתא והנה - בריאה ושלמה.\n" +
	// 				"הצייד אסף מהר אבנים, מילא בהן את בטן ה<אויב>, בלי להעיר אותו, ותפר את החתך. כשה<אויב> התעורר וראה את הצייד, סבתא וכיפה אדומה, קפץ מהמיטה והתחיל לברוח.\n" +
	// 				"הוא רץ עד שהגיע לנהר. הוא היה צמא מאוד ורצה לשתות מים, אך האבנים שבבטן משכו אותו מהגדה והוא נפל לתוך הנהר. הזרם סחף אותו רחוק, רחוק מהיער. לא ידוע מה קרה ל<אויב>, אך הוא לא חזר ליער לעולם.\n" +
	// 				"כיפה אדומה , סבתא שלה והצייד אכלו את ה<אוכל> ושתו מיץ. כיפה אדומה הבטיחה שלהבא לא תסטה מהשביל לסבתא, ושלא תדבר בדרך עם חיות ואנשים שאינה מכירה.\n", "Sinderela.jpg", false, null, u4o1, uArr4, u3o1, 4);
	// 		Page p4o2 = new Page("אחרי הארוחה הדשנה הזו נשכב ה<אויב> שוב במיטה ונרדם. אבל תוך כדי שינה התחיל לנחור חזק, עד שקולות הנחירה נשמעו בכל היער.\n" +
	// 				"לא הרחק מביתה של סבתא, עבר הצייד. \"מה קרה לה?\" חשב \"למה סבתא נוחרת כל כך חזק. אולי היא חולה?\" והוא נכנס לבית של סבתא כדי לבדוק.\n" +
	// 				"כשראה את ה<אויב> הרע שוכב במיטה ונוחר, הוציא סכין חדה מכיסו, פתח את בטן ה<אויב> ומהבטן יצאו סבתא וכיפה אדומה, והנה – בריאות ושלמות.\n" +
	// 				"הצייד אסף מהר אבנים, מילא בהן את בטן ה<אויב>, בלי להעיר אותו, ותפר את החתך. כשה<אויב> התעורר וראה את הצייד, סבתא וכיפה אדומה, קפץ מהמיטה והתחיל לברוח.\n" +
	// 				"הוא רץ עד שהגיע לנהר. הוא היה צמא מאוד ורצה לשתות מים, אך האבנים שבבטן משכו אותו מהגדה והוא נפל לתוך הנהר. הזרם סחף אותו רחוק, רחוק מהיער. לא ידוע מה קרה ל<אויב>, אך הוא לא חזר ליער לעולם.\n" +
	// 				"כיפה אדומה , סבתא שלה והצייד אכלו את ה<אוכל> ושתו מיץ. כיפה אדומה הבטיחה שלהבא לא תסטה מהשביל לסבתא, ושלא תדבר בדרך עם חיות ואנשים שאינה מכירה.\n", "Sinderela.jpg", false, null, u4o2, uArr4, u3o2, 4);

	// 		pages.add(p1);
	// 		pages.add(p2);
	// 		pages.add(p3o1);
	// 		pages.add(p3o2);
	// 		pages.add(p4o1);
	// 		pages.add(p4o2);

	// 		List<Question> questions = new ArrayList<Question>();
	// 		Question q1 = new Question("input", "?מה שם הילדה", null, "שם");
	// 		Question q2 = new Question("input", "מה הביאה הילדה לסבתא לאכול?", null, "אוכל");
	// 		Question q3 = new Question("input", "את מי פגשה הילדה בדרך?", null, "אויב");
	// 		List<String> hobby = new ArrayList<String>();
	// 		hobby.add("קטפה פרחים");
	// 		hobby.add("רקדה");
	// 		hobby.add("שרה");
	// 		hobby.add("שיחקה עם חיות היער");
	// 		Question q4 = new Question("combo", "מה הילדה עשתה בדרך לסבתא?", hobby, "תחביב");

	// 		questions.add(q1);
	// 		questions.add(q2);
	// 		questions.add(q3);
	// 		questions.add(q4);

	// 		Map<String,String> defaultLabelInText = new HashMap<String, String>();
	// 		defaultLabelInText.put("שם","כיפה אדומה");
	// 		defaultLabelInText.put("אוכל","מרק");
	// 		defaultLabelInText.put("אויב","זאב");
	// 		defaultLabelInText.put("תחביב","קטפה פרחים");

	// 		BookTemplate bt1 = new BookTemplate("כיפה אדומה", pages, questions, bookCover.getId(),defaultLabelInText);

	// 		BTrepository.insert(bt1);

	// 	};
	// }
//

//	@Bean
//	CommandLineRunner runner(BookTemplateRepository BTRepository, BookCoverRepository BCRepository) {
//
//		return args -> {
//
//			BookCover bookCover = new BookCover("עמי ותמי", "Sinderela.jpg",null);
//			BCRepository.insert(bookCover);
//
//			List<Page> pages = new ArrayList<Page>();
//			UUID u1 = UUID.randomUUID();
//			UUID u2 = UUID.randomUUID();
//			UUID u3o1 = UUID.randomUUID();
//			UUID u3o2 = UUID.randomUUID();
//			UUID u4 = UUID.randomUUID();
//			UUID[] uArr1 = {u2, null};
//			UUID[] uArr2 = {u3o1, u3o2};
//			UUID[] uArr3o1 = {u4, null};
//			UUID[] uArr3o2 = {null, null};
//			UUID[] uArr4 = {null, null};
//
//			List<String> options = new ArrayList<String>();
//			options.add("את הנחל שמוביל לכפר השכן");
//			options.add("בית קטן שקירותיו שוקולד");
//			TurningPoint turningPoint = new TurningPoint("מה ראו הילדים ביער?", options, 2);
//
//			Page p1 = new Page("היה היה פעם יער גדול בארץ רחוקה, וביער גרו בבית קטן שני ילדים שקראו להם <שם> ו<שם_לאח>. המשפחה של <שם> ו<שם_לאח>. הייתה עניה מאוד. \n" +
//					"לילה אחד אמרה האמא לאבא: \"רק כיכר לחם אחת נשארה לנו בבית. בבוקר נשאיר את הילדים ביער, אולי ימצאו להם פירות יער לאכול\".\n" +
//					"ענה האבא: \"הרי זה נורא!\" אמרה האם: \"מוטב שלא נראה אותם סובלים מרעב\". \n" +
//					"שמעו אותם הילדים ובכו. <שם> חיבקה את אחיה, יצאה החוצה, אספה <סימני_דרך> וחזרה למיטתה.\n" +
//					"בבוקר נתנה להם אמא פרוסת לחם ולקחה אותם למעמקי היער.\n" +
//					"בעודם הולכים, פיזרה <שם> <סימני_דרך> וסימנה את השביל שבו הם הלכו. \n" +
//					"בקרחת היער הבעירה אמא מדורה ואמרה: \"שבו והתחממו ליד האש. אביכם ואני נלך לחפש פחמים\".\n" +
//					"הילדים נשארו לבדם.\n", "Sinderela.jpg", false, null, u1, uArr1, null, 1);
//			Page p2 = new Page("<שם_לאח> אמר ל<שם>: \"אני פוחד, וקר לי כלכך..\"\n" +
//					"ענתה לו <שם>: \"אל תדאג, נחזור הביתה בעזרת ה<סימני_דרך> שפיזרתי..\"\n" +
//					"חזרו <שם> ו<שם_לאח> הביתה. שמחו ההורים לרגע, אך כאשר הילדים שכבו לישון רעבים, שוב שמעו <שם> ו<שם_לאח> את ההורים מתלחששים. \n" +
//					"אמרה האם: \" רק חצי כיכר לחם נשארה. בבוקר נשאיר את הילדים ביער\". \n" +
//					"ענה האב: \"הרי זה נורא!\" \n" +
//					"אמרה האם: \"מוטב שלא נראה אותם סובלים מרעב\". \n" +
//					"שמעו הילדים ובכו. <שם> חיבקה את אחיה ואמרה לו: \"אצא לאסוף עוד <סימני_דרך> שנוכל לחזור גם מחר..\"\n" +
//					"<שם_לאח> רץ לדלת ואמר ל<שם>: <שם>, הדלת נעולה!\" והם הלכו לישון בוכים ומפוחדים. \n" +
//					"בבוקר נתנה להם אמא פרוסת לחם אחרונה ולקחה אותם לעובי היער. \n" +
//					"בעוד הולכים פוררה ופיזרה <שם> את הלחם לפירורים לסמן את השביל. שוב הבעירה אמא מדורה ואמרה ואמרה: \"שבו התחממו ליד האש. אביכם ואני נלך לאסוף פחמים\". \n" +
//					"הילדים נשארו לבדם. בערב אמר <שם_לאח>: \"<שם>, בואי נחזור הביתה.\" ו<שם> אמרה: \"אוי! הציפורים אכלו את כל פירורי הלחם..\"\n" +
//					"<שם> ו<שם_לאח> הלכו יד ביד בין העצים המפחידים. \n", "Sinderela.jpg", true, turningPoint, u2, uArr2, u1, 2);
//			Page p3o1 = new Page("לפתע ראו את הנחל שמוביל לכפר השכן, <שם> ו<שם_לאח> הלכו בעקבותיו והגיעו לכפר. \n" +
//					"<שם> למדה לאפות והחלה לעבוד אצל האופה של הכפר, כך השיגה מספיק כסף בשבילה ובשביל <שם_לאח> כדי להמשיך לגור בכפר, לקנות להם את האוכל האהוב עליהם - <אוכל_אהוב> ואת הקינוח האהוב עליהם - <קינוח_אהוב>, אותם אכלו כמעט כל יום, והם חיו באושר ועושר עד עצם היום הזה\n", "Sinderela.jpg", false, null, u3o1, uArr3o1, u2, 3);
//			Page p3o2 = new Page("לפתע ראו שביל נחמד ובית קטן שקירותיו שוקולד, מן החלונות מציצות סוכריות, וגגו – עוגיות. <שם_לאח> התקרב וקטף סוכריה, <שם> לקחה שוקולד מן הקיר. \n" +
//					"השניים קטפו המון ממתקים, עד שפתאום נפתח חלון, ואשה זקנה עם עיניים שחורות ואף ארוך אמרה: \"ילדים ברוכים הבאים! הכנסו פנימה, ואתן לכם <אוכל_אהוב> ו<קינוח_אהוב>\".\n" +
//					"<שם> ו<שם_לאח> נכנסו לבית הממתקים, ולפניהם שולחן עגול, ועליו <אוכל_אהוב> ו<קינוח_אהוב>. הם טעמו מעט ואכלו עוד ולא השאירו פירור. \n" +
//					"ובינתיים, הזקנה הכינה להם מיטות ושמיכות עשויות קורי עכביש, והם שכבו לישון שבעים ומרוצים. \n" +
//					"בבוקר אמרה הזקנה, ובידה מטאטא: \"לך ילד אל המעיין והבא מים בדלי. גרוף את השביל, כבס את הבגדים, והכן <אוכל_אהוב> טעים. ואת <שם>, הכנסי לכלוב ואל תעשי דבר\". הילדים נבהלו מן הזקנה שהפכה פתאום למכשפה ורצו לברוח, אך היא עצרה אותם בכוח וצחקה\" \"אוהוהו, אתם שלי עכשיו!\" \n", "Sinderela.jpg", false, null, u3o2, uArr3o2, u2, 3);
//			Page p4 = new Page("המכשפה הכניסה את <שם> ו<שם_לאח> לכלוב והתחילה להכין מרק..\n" +
//					"לחשה <שם> ל<שם_לאח>: \"היא רוצה לבשל אותנו! חייבים לעשות משהו!\"\n" +
//					"קראה המכשפה ל<שם_לאח>: \"ילד, בוא לכאן ובדוק אם הלחם מוכן\"\n" +
//					"המכשפה פתחה את הכלוב והוציאה את <שם_לאח>. <שם_לאח> התכופף לתנור ואמר למכשפה: \" אני לא יודע אם הלחם מוכן\", המכשפה פתחה את דלת התנור והכניסה את ראשה פנימה. מיד דחף אותה <שם_לאח> וסגר את התנור. \n" +
//					"המכשפה קראה: \"פתח מהר, ילד קטן – אחרת אהפוך אותך לצפרדע שמנה!\" \n" +
//					"אבל <שם_לאח> לא נבהל. הוא שחרר את <שם> מהכלוב, ושניהם מילאו את הכיסים ממתקים, ברחו מן הבית וחזרו הביתה. ובבית ההורים שמחו למראה הילדים והממתקים, והבטיחו שלא ישלחו אותם הרחק מביתם. \n", "Sinderela.jpg", false, null, u4, uArr4, u3o2, 4);
//
//			pages.add(p1);
//			pages.add(p2);
//			pages.add(p3o1);
//			pages.add(p3o2);
//			pages.add(p4);
//
//			List<Question> questions = new ArrayList<Question>();
//			Question q1 = new Question("input", "מה שם הילדה?", null, "שם");
//			Question q2 = new Question("input", "מה שם האח של הילדה?", null, "שם_לאח");
//			Question q3 = new Question("input", "מה האוכל האהוב על האחים?", null, "אוכל_אהוב");
//			Question q4 = new Question("input", "מה הקינוח האהוב על האחים?", null, "קינוח_אהוב");
//			List<String> roadSigns = new ArrayList<String>();
//			roadSigns.add("חלוקי נחל");
//			roadSigns.add("צדפות");
//			roadSigns.add("מקלות");
//			Question q5 = new Question("combo", "מה יפזרו האחים ביער כדי למצוא את הדרך הביתה?", roadSigns, "סימני_דרך");
//
//			questions.add(q1);
//			questions.add(q2);
//			questions.add(q3);
//			questions.add(q4);
//			questions.add(q5);
//
//			Map<String,String> defaultAnswers = new HashMap<String, String>();
//			defaultAnswers.put("שם","תמי");
//			defaultAnswers.put("שם_לאח","עמי");
//			defaultAnswers.put("אוכל_אהוב","מרק ולחם");
//			defaultAnswers.put("קינוח_אהוב","גלידה וקצפת");
//			defaultAnswers.put("סימני_דרך","חלוקי_נחל");
//
//			BookTemplate bt1 = new BookTemplate("עמי ותמי", pages, questions, bookCover.getId(), defaultAnswers);
//
//			BTRepository.insert(bt1);
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
//	BookCover bookCover4 = new BookCover("כיפה אדומה","KipaAduma.jfif",null);

//		coverRepository.insert(bookCover1);
//		coverRepository.insert(bookCover2);
//		coverRepository.insert(bookCover3);
//		coverRepository.insert(bookCover4);

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
