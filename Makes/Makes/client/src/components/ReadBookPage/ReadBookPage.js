import React, {useState} from "react";
import Header from "../UI/Header";
import ReadBookPageContent from "./ReadBookPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";


const DUMMY_BOOK = [
    {
      id: 'p1',
      pageNum: '1',
      text:'כיפה אדומה הלכה לבקר את סבתא',
      Image: 'KipaAduma.jfif',
      turningPointExist: false,
      turningPointData: {
        text: '',
        leftOption:'' ,
        rightOption:''
     },
      nextPageId: ['p2',null],
      prevPageId: null
      
    },
    
    {
        id: 'p2',
        pageNum: '2',
        text:'בדרך היא נתקלה בזאב הרשע',
        Image: 'KipaAduma.jfif',
        turningPointExist: true,
        turningPointData: {
          text: 'מה כיפה אדומה צריכה להגיד לזאב?',
          leftOption:'אני לא מדברת עם זרים' ,
          rightOption:'רוצה לבוא לסבתא שלי?'
       },
       nextPageId: ['p3','p4'],
       prevPageId: 'p1'
      },

      {
        id: 'p3',
        pageNum: '3',
        text:'כיפה אדומה המשיכה בדרך והזאב נעלב והלך לביתו',
        Image: 'KipaAduma.jfif',
        turningPointExist: false,
        turningPointData: {
            text: '',
            leftOption:'' ,
            rightOption:''
         },
       nextPageId: [null,null] ,
       prevPageId: 'p2'
      },
      {
        id: 'p4',
        pageNum: '3',
        text:'כיפה וזאב הגיעו לסבתא והזאב אכל את שניהם',
        Image: 'KipaAduma.jfif',
        turningPointExist: false,
        turningPointData: {
            text: '',
            leftOption:'' ,
            rightOption:''
         },
       nextPageId: [null,null],
       prevPageId: 'p2'
      },
  ];


const ReadBookPage = (props) => {      

  const [books, setBooks] = useState([]);

  
  // const transformedBook = book => {
  //   const loadedBook=[];
  //   // booksArr.forEach(book =>  loadedBooks.push({name: book.name, coverPhoto: book.coverPhoto}));
  // setBooks(loadedBook);
  // };

  // const {isLoading, error, sendRequest: fetchBook} = 
  // useHttp({url: 'http://localhost:8080/books/'},
  // transformedBook
  // );

  // useEffect(()=>{
  //   fetchBook();
  // },[]);

    return (
        <React.Fragment>
            <Header >
                <label>קריאת ספר</label>
                { <button >שמור ספר בגלרייה</button>}
            </Header>
            <ReadBookPageContent pages={DUMMY_BOOK}/>
            <Footer>
                <Button onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
                
            </Footer>
        </React.Fragment>
    );
}
export default ReadBookPage;