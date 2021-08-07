import React, {useState, useEffect, useContext} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import AuthContext, {AuthContextProvider} from "./store/auth-context";
import useHttp from "./hooks/use-http";

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

    const authCtx = useContext(AuthContext);

    const isLoggedIn = authCtx.isLoggedIn;

    const [page, setPage] = useState("mainPage");
    const [bookCards, setBookCards] = useState([]);
    const [chosenBookName, setChosenBookName] = useState("כיפה אדומה");
    const [dummyGalleryBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE

    const transformedBooks = booksArr => {
      const loadedBooks=[];
      booksArr.forEach(book =>  loadedBooks.push({name: book.name, coverPhoto: book.coverPhoto}));
      console.log(loadedBooks);
    setBookCards(loadedBooks);
    };

    const {isLoading, error, sendRequest: fetchBooks} = 
    useHttp({url: 'http://localhost:8080/booksCovers/'},
    transformedBooks
    );

    useEffect(()=>{
      fetchBooks();
    },[]);

    const bookItemClickedHandler = () => {
      setPage("createBookPage");
    };

    const notLoggedInHandler = (book) => {
    alert("אנא התחבר על מנת להשלים את הפעולה");
  };


    const galleryBookItemClickedHandler = () => {
      setPage("readBookPage");
    };

      const createBookClickedHandler = () => {
        setPage("readBookPage");
      };
    
      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };

      const myGalleryHandler = () => {
        setPage("galleryPage");
      };

      const galleryItemDeleteHandler = () =>
      {
      }

    
    return (
        <React.Fragment>
        <AuthContextProvider>
          
            {isLoading && <h1>...אנא המתן</h1>}

            {!isLoading && page === 'mainPage' && <MainPage items={bookCards}
            onBookItemClicked={bookItemClickedHandler} 
             onGalleryClicked={myGalleryHandler}
             onNotLoggedIn={notLoggedInHandler}/>}

            {page === 'createBookPage' && <CreateBookPage
            onBackToMainMenuButtonClicked={backButtonClickedHandler} 
            onCreateBook={createBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage
             onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={dummyGalleryBooks} 
            onBackToMainMenuButtonClicked={backButtonClickedHandler} 
            onGalleryBookItemClicked={galleryBookItemClickedHandler}
            onGalleryItemDeletion={galleryItemDeleteHandler}/>} 


        </AuthContextProvider>
        </React.Fragment>
    )
}

export default App;