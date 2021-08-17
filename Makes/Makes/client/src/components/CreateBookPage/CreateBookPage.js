import React, {useState, useEffect} from "react";
import Header from "../UI/Header";
import CreateBookPageContent from "./CreateBookPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import useHttp from "../../hooks/use-http";
import './CreateBookPage.css';


const CreateBookPage = (props) => {        

    const [questions, setQuestions] = useState([]);
    
      const transformedQuestions = questionsArr => {

        const loadedQuestions=[];
        questionsArr.forEach(question =>  loadedQuestions.push({id: question.id, type: question.answerType, label: question.label, options: question.answerOptions}));
    
        setQuestions(loadedQuestions);

      };
  
      const {sendRequest: fetchQuestions} = 
      useHttp({url: 'http://localhost:8080/questionnaire/?name='+ localStorage.getItem('bookName')},
      transformedQuestions
      );
  
      useEffect(()=>{
        fetchQuestions();
      },[]);
      
    return (
        <React.Fragment>
            <Header >
                <label id="create-book-label">יצירת ספר</label>
                
            </Header>
            <CreateBookPageContent questions={questions} onCreateBook={props.onCreateBook}/>
            <Footer>
                <Button onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
            </Footer>
        </React.Fragment>
    );
}
export default CreateBookPage;