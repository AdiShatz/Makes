import React, {useState, useEffect, useContext} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import { AuthContextProvider } from "./store/auth-context";
import useHttp from "./hooks/use-http";


// const DUMMY_BOOKS = [
//   {
//     id: 'b1',
//     name: 'כיפה אדומה',
//     coverPhoto: "KipaAduma.jfif"
//   },
//   { 
//       id: 'b2',
//     name: 'סינדרלה',
//     coverPhoto: "Sinderela.jpg"
//   },
//   { 
//       id: 'b3',
//     name: 'פיטר פן',
//     coverPhoto: "Piterpen.jpg"
//   },
//   { 
//       id: 'b4',
//     name: 'שילגיה',
//     coverPhoto: "Shilgiya.jpeg"
//   }
// ];

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
    const [dummyGalleryBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE

    const transformedBooks = booksArr => {
      const loadedBooks=[];

      booksArr.forEach(book =>  loadedBooks.push({name: book.name}));


    setBooks(loadedBooks);
    };

    const {isLoading, error, sendRequest: fetchBooks} = 
    useHttp({url: 'http://localhost:8080/books'},
    transformedBooks
    );

    useEffect(()=>{
      fetchBooks();
    },[]);

    const bookItemClickedHandler = (book) => {
      setPage("createBookPage");
    };

    const galleryBookItemClickedHandler = (book) => {
      setPage("readBookPage");
    };

      const createBookClickedHandler = (book) => {
        setPage("readBookPage");
      };
    
      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };

      const myGalleryHandler = () => {
        setPage("galleryPage");
      };

      const notLoggedInHandler = () => {
        alert("אנא התחבר על מנת להשלים את הפעולה");
      };

      const galleryItemDeleteHandler = () =>
      {
          
      }

    
    return (
        <React.Fragment>
        <AuthContextProvider>
          
            {isLoading && <h1>...אנא המתן</h1>}

            {!isLoading && page === 'mainPage' && <MainPage items={books} 
            onBookItemClicked={bookItemClickedHandler} 
            onNotLoggedIn={notLoggedInHandler}
             onGalleryClicked={myGalleryHandler}/>}

            {page === 'createBookPage' && <CreateBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler} onCreateBook={createBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={dummyGalleryBooks} 
            onBackToMainMenuButtonClicked={backButtonClickedHandler} 
            onGalleryBookItemClicked={galleryBookItemClickedHandler}
            onGalleryItemDeletion={galleryItemDeleteHandler}/>} 


        </AuthContextProvider>
        </React.Fragment>
    )
}

export default App;