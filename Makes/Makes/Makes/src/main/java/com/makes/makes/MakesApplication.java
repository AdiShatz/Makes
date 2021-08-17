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


	@Bean
	CommandLineRunner runner(BookTemplateRepository repository) {

		return args -> {

			List<Page> pages = new ArrayList<Page>();
			UUID u1 = UUID.randomUUID();
			UUID u2 = UUID.randomUUID();
			UUID u3 = UUID.randomUUID();
			UUID u4 = UUID.randomUUID();
			UUID u5o1 = UUID.randomUUID();
			UUID u5o2 = UUID.randomUUID();
			UUID[] uArr1 = {u2, null};
			UUID[] uArr2 = {u3, null};
			UUID[] uArr3 = {u4, null};
			UUID[] uArr4 = {u5o1, u5o2};
			UUID[] uArr5o1 = {null, null};
			UUID[] uArr5o2 = {null, null};

			List<String> options = new ArrayList<String>();
			options.add("כן");
			options.add("לא");
			TurningPoint turningPoint = new TurningPoint("האם הם ייתפסו?", options, 2);

			Page p1 = new Page("<שם> ואמא שלו היו עניים מרודים וגרו בביקתה קטנה כשכל רכושם הוא <חיה> . יום אחד ראתה אמו של <שם> שאין להם כסף אפילו לאכול, ולכן ביקשה בצער רב מ<שם> שילך לשוק בעיר ושימכור את <חיה>.\n" +
					"<שם> יצא בדרכו לשוק, מוליך את ה<חיה> בחבל ושורק לעצמו מנגינות עליזות. בדרך פגש איש זקן. ״שלום בחור צעיר״, אמר לו הזקן, ״אני רואה שיש לך פה <חיה> יפה. לאן אתה הולך?״\n" +
					"״לשוק בעיר״, ענה <שם>, ״למכור את ה<חיה>״.\n" +
					"״אה, למכור…״ אמר הזקן, ״אם כך יש לי פה משהו מיוחד מאוד בשבילך״. הוא פתח את ידו השמאלית והראה ל<שם> שלוש אפונים קטנות. ״אלו לא סתם אפונים – אלו אפוני קסם. אם תיתן לי את ה<חיה> בתמורה אביא לך את אפוני הקסם האלה.״\n" +
					"<שם> התלהב מהעיסקה הטובה הזאת והסכים מיד. הוא מסר לזקן את ה<חיה> ולקח את האפונים. וכך כשהאפונים בידיו הוא חזר הביתה שמח על מזלו הטוב.\n", "Sinderela.jpg", false, null, u1, uArr1, null, 1);
			Page p2 = new Page("אמו ראתה שהוא חזר בלי ה<חיה> וקיבלה את פניו בשמחה. ״מכרת את ה<חיה>?״ היא שאלה.\n" +
					"״כן״, ענה לה <שם>.\n" +
					"״וכמה קיבלת ? מטבע זהב? שני מטבעות?״\n" +
					"״יותר טוב מכך!״ קרא <שם>, והראה לאמו את שלושת האפונים, ״אלו אפוני פלא!״\n" +
					"״אוי, <שם>…״, אמרה אמו בצער. היא לקחה את האפונים מידו והשליכה אותן מחוץ לחלון. ״איך אתה נותן לרמות אותך כל-כך בקלות…״\n" +
					"<שם> ואמו נאלצו ללכת לישון רעבים באותו לילה מכיוון שנותרו ללא כסף לאוכל. בבוקר פתח <שם> את חלון חדרו – ולתדהמתו ראה שיח אפונים ענק צומח מהמקום אליו זרקה אמו את אפוני הקסם. השיח התנשא לגובה רב, עובר את גג הבית ומטפס למעלה עד שהגיע לעננים.\n" +
					"<שם> רץ החוצה והחל לטפס על השיח, סקרן לראות מה יש בקצהו. הוא טיפס עוד ועוד עד שהבית נראה קטן כמו קובית לגו והאנשים על האדמה נראו כמו נמלים. הוא המשיך לטפס עד שהגיע לענן גדול. כשהמשיך לטפס הוא גילה שקצה שיח האפונים מגיע לשער טירה עצומה שיושבת על הענן.\n", "Sinderela.jpg", false, null, u2, uArr2, u1, 2);
			Page p3 = new Page("<שם> טיפס על הענן וניגש לשער הטירה. הוא עבר אותו ומצא עצמו בתוך חדר ענק, עם שולחן ענק וכסא ענק. בקצה החדר, על הרצפה, ראה <שם> כלוב זהב ובתוכו תרנגולת. כשהיא ראתה את <שם> היא קראה לעברו בקול: ״בבקשה תוציא אותי מפה! אני תרנגולת קסומה שמטילה ביצי זהב – כדאי לך לקחת אותי איתך!״.\n" +
					"<שם> ניגש לכלוב, פתח אותו ואסף את התרנגולת אל מתחת זרועו. לפתע הוא הרגיש את האדמה רועדת. <שם> רץ לרגלו של השולחן הענקי והסתתר מאחוריה, ברגע בו <יצור_ענק> מפלצתי נכנס לחדר.\n" +
					"ה<יצור_ענק> היה בגובה של 3 בני אדם ואחז בידו מקל גדול. עיניו היו אדומות ושיניו חדות. <שם> נשם בשקט, מקווה שהיצור לא יראה אותו. לפתע ה<שם> רחרח את האוויר וקרא בקול שהתגלגל מקצה אחד של החדר לקצה השני:\n" +
					"פי פה פו פם\n" +
					"אני מריח ריח אדם,\n" +
					"חי או מת – זאת כבר אדע\n" +
					"אכין ממנו סעודה!\n" +
					"הוא רחרח שוב את האוויר – ופנה לכיוון <שם>, חיוך רעב על פניו.\n", "Sinderela.jpg", false, null, u3, uArr3, u2, 3);
			Page p4 = new Page("<שם> החל לרוץ, התרנגולת תחת זרועו. הוא רץ לאורך החדר, מרגיש את האדמה רועדת כשה<יצור_ענק> החל ללכת אחריו. הוא רץ דרך הדלת אל מחוץ לטירה, ואז תפס את שיח האפונה והחל לרדת במהירות. הוא ירד מהר ככל שיכול עד שהגיע לאדמה. כשהרים את ראשו הוא יכול היה לראות את ה<יצור_ענק> מעליו במרחק מטפס אט-אט למטה.", "Sinderela.jpg", true, turningPoint, u4, uArr4, u3, 4);
			Page p5o1 = new Page("חיש מהר ירד ה<יצור_ענק> מהשיח ותפס את <שם> והתרנגולת הקסומה, ולקח אותם לביתו שבעננים.\n" +
					"<שם> חיכה שירד הערב, וה<יצור_ענק> יירדם, והרג את ה<יצור_ענק> בעזרת חבל ענק, והוא גר בביתו הענק עם התרנגולת הקסומה ואימו מאז. \n", "Sinderela.jpg", false, null, u5o1, uArr5o1, u4, 5);
			Page p5o2 = new Page("מיד רץ <שם> לתוך ביתו ויצא אוחז בגרזן. הוא הניף אותו וחבט בשיח האפונים. שוב ושוב הוא הכה בשיח, עד שקול אדיר נשמע כשהשיח נשבר ונפל – ויחד איתו נפל ה<יצור_ענק> מגובה אדיר. האדמה רעדה כשהענק פגע בה, והוא מת במקום.\n" +
					"כשאמו של <שם> הגיעה הביתה הראה לה <שם> את התרנגולת הקסומה, והם מכרו את ביצי הזהב והפכו לעשירים. מאז לא חסר להם כלום, והם חיים בעושר ואושר עד עצם היום הזה.\n", "Sinderela.jpg", false, null, u5o2, uArr5o2, u4, 5);

			pages.add(p1);
			pages.add(p2);
			pages.add(p3);
			pages.add(p4);
			pages.add(p5o1);
			pages.add(p5o2);

			List<Question> questions = new ArrayList<Question>();
			Question q1 = new Question("input", "?מה שם הילד", null, "שם");
			Question q2 = new Question("input", "איזו חיה מגדל ג'ק?", null, "חיה");
			List<String> giantCreature = new ArrayList<String>();
			giantCreature.add("ענק");
			giantCreature.add("ציקלופ");
			giantCreature.add("דרקון");
			giantCreature.add("מפלץ");
			Question q3 = new Question("combo", "איזה יצור יפגוש ג'ק?", giantCreature, "יצור_ענק");

			questions.add(q1);
			questions.add(q2);
			questions.add(q3);

			BookTemplate bt1 = new BookTemplate("הדייג ואשתו", pages, questions);

			repository.insert(bt1);

		};
	}
}
