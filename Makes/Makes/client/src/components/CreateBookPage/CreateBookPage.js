import React, {useState} from "react";
import Header from "../UI/Header";
import CreateBookPageContent from "./CreateBookPageContent";
import Footer from "../UI/Footer";
import BackButton from "../UI/BackButton";

const DUMMY_QUESTIONS = [
    {
      id: 'q1',
      type: 'text',
      label: 'שם הילד',
      options: ['גבי','לילך','עדי','ניר'] 
    },
    { 
        id: 'q2',
        type: 'combo',
        label: 'בסיפור נבקר את',
        options: ['סבתא','סבא','דודה','אמא'] 
    },
    { 
        id: 'q3',
        type: 'combo',
        label: 'דרך איפה נלך',
        options: ['יער','חוף הים','פארק','מערה'] 
    },
    { 
        id: 'q4',
        type: 'combo',
        label: 'חיה מרושעת',
        options: ['אריה','נחש','נמר','זאב'] 
    }
  ];


const CreateBookPage = (props) => {        

    const [questions, setQustions] = useState(DUMMY_QUESTIONS);

    return (
        <div>
            <Header >
                <label>יצירת ספר</label>
                
            </Header>
            <CreateBookPageContent questions={questions}/>
            <Footer>
                <BackButton onBackButtonClicked={props.onBackButtonClicked}/>
            </Footer>
        </div>
    );
}
export default CreateBookPage;