import React, {useState} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";

const DUMMY_BOOKS = [
    {
      id: 'b1',
      name: 'כיפה אדומה',
      coverPhoto: "../../images/photo1.png"
    },
    { 
        id: 'b2',
      name: 'סינדרלה',
      coverPhoto: "../../images/photo2.jpg"
    },
    { 
        id: 'b3',
      name: 'פיטר פן',
      coverPhoto: "../../images/photo1.png"
    },
    { 
        id: 'b4',
      name: 'שילגיה',
      coverPhoto: "../../images/photo2.jpg"
    }
  ];

  const App = () => {

    const [page, setPage] = useState("mainPage");
    const [books, setBooks] = useState(DUMMY_BOOKS);

    const bookItemClickedHandler = (book) => {
        setPage("createBookPage");
      };
    
      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };
    

    return (
        <div>
            {page === 'mainPage' && <MainPage items={books} onBookItemClicked={bookItemClickedHandler}/>}

            {page === 'createBookPage' && <CreateBookPage onBackButtonClicked={backButtonClickedHandler}/>} 

        </div>
    )
}

export default App;