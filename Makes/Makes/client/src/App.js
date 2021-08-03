import React, {useState, useEffect} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import { AuthContextProvider } from "./store/auth-context";
import useHttp from "./hooks/use-http";

const DUMMY_BOOKS = [
  {
    id: 'b1',
    name: 'כיפה אדומה',
    coverPhoto: "KipaAduma.jfif"
  },
  { 
      id: 'b2',
    name: 'סינדרלה',
    coverPhoto: "Sinderela.jpg"
  },
  { 
      id: 'b3',
    name: 'פיטר פן',
    coverPhoto: "Piterpen.jpg"
  },
  { 
      id: 'b4',
    name: 'שילגיה',
    coverPhoto: "Shilgiya.jpeg"
  }
];

const DUMMY_GALLERY_BOOKS = [
  {
    id: 'b1',
    name: 'כיפה אדומה',
    coverPhoto: "KipaAduma.jfif"
  },
  { 
      id: 'b4',
    name: 'שילגיה',
    coverPhoto: "Shilgiya.jpeg"
  }
];

  const App = () => {

    const [page, setPage] = useState("mainPage");
    const [books, setBooks] = useState([]); 
    const [dummyBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE

    const transformedBooks = booksObj => {
      const loadedBooks=[];

      for(const bookKey in booksObj){
      loadedBooks.push({id: bookKey, text: booksObj[bookKey].text})
      }

    setBooks(loadedBooks);
    };

    const {isLoading, error, sendRequest: fetchBooks} = 
    useHttp({url: 'http://localhost:8080/api/books'},
    transformedBooks
    );

    useEffect(()=>{
      fetchBooks();
    },[]);

    const bookItemClickedHandler = (book) => {
        setPage("createBookPage");
      };

      const CreateBookClickedHandler = (book) => {
        setPage("readBookPage");
      };
    
      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };

      const myGalleryHandler = () => {
        setPage("galleryPage");
      };
    
    return (
        <React.Fragment>
        <AuthContextProvider>
            {isLoading && <h1>...אנא המתן</h1>}

            {!isLoading && page === 'mainPage' && <MainPage items={DUMMY_BOOKS} onBookItemClicked={bookItemClickedHandler} onGalleryClicked={myGalleryHandler}/>}

            {page === 'createBookPage' && <CreateBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler} onCreateBook={CreateBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={dummyBooks} onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 


        </AuthContextProvider>
        </React.Fragment>
    )
}

export default App;