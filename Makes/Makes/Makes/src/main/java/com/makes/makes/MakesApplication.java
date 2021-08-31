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
}
