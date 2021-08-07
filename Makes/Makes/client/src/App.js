import React, {useState, useContext} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import AuthContext, {AuthContextProvider} from "./store/auth-context";

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
    const [dummyGalleryBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE


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

            {page === 'mainPage' && <MainPage 
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