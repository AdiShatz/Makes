import React, {useState} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";

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

    const [books, setBooks] = useState(DUMMY_BOOKS); // TO DELETE?

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
          
            {page === 'mainPage' && <MainPage items={books} onBookItemClicked={bookItemClickedHandler} onGalleryClicked={myGalleryHandler}/>}

            {page === 'createBookPage' && <CreateBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler} onCreateBook={CreateBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={DUMMY_GALLERY_BOOKS} onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 


        </React.Fragment>
    )
}

export default App;