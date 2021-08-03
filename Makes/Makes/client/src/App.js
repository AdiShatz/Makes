import React, {useState} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import { AuthContextProvider } from "./store/auth-context";

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
    const [error, setError] = useState(null);


    const fetchBooksHandler = () => {
      setError(null);

      fetch('http://localhost:8080/api/books')
      .then((response) =>{
        return response.json();
      })
      .then((data) => {
        setBooks(data.results);
        let errorMessage= 'מצטערים, הייתה שגיאה בטעינת הדף';
                     if(data && data.error && data.error.message){ 
                     errorMessage = data.error.message; 
                     }
                     throw new Error(errorMessage);
      }).catch(err => {
        alert(err.message);
        });
    }
    

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

          <button onClick= {fetchBooksHandler}>יבא נתונים</button>
          
            {page === 'mainPage' && <MainPage items={books} onBookItemClicked={bookItemClickedHandler} onGalleryClicked={myGalleryHandler}/>}

            {page === 'createBookPage' && <CreateBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler} onCreateBook={CreateBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={dummyBooks} onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 


        </AuthContextProvider>
    )
}

export default App;