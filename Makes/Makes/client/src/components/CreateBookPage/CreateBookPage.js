import React, {useState} from "react";
import Header from "../UI/Header";
import CreateBookPageContent from "./CreateBookPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button"

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
        <React.Fragment>
            <Header >
                <label>יצירת ספר</label>
                
            </Header>
            <CreateBookPageContent questions={questions} onCreateBook={props.onCreateBook}/>
            <Footer>
                <Button onClick={props.onBackButtonClicked}>חזור</Button>
            </Footer>
        </React.Fragment>
    );
}
export default CreateBookPage;