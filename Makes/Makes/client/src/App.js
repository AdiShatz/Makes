import React, {useState, useCallback, useEffect} from "react";
import MainPage from "./components/MainPage/MainPage";
import CreateBookPage from "./components/CreateBookPage/CreateBookPage";
import ReadBookPage from "./components/ReadBookPage/ReadBookPage";
import GalleryPage from "./components/GalleryPage/GalleryPage";
import AuthContext, {AuthContextProvider} from "./store/auth-context";
import AdminPage from "./components/AdminPage/AdminPage";

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
    const [bookPages, setBookPages] = useState([]);
    const [bookName, setBookName] = useState();
    const [dummyGalleryBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE

    // const isAdminUser = () => {
    //   if(localStorage.getItem.name)==
    // }

    const bookItemClickedHandler = () => {
      setPage("createBookPage");
    };

    const notLoggedInHandler = () => {
    alert("אנא התחבר על מנת להשלים את הפעולה");
  };


    const galleryBookItemClickedHandler = () => {
      setPage("readBookPage");
    };

      const createBookClickedHandler = (newBookData, chosenBookName) => {
          let url = "http://localhost:8080/customBooks/";
          setBookName(chosenBookName);
            fetch(url,
            {
                method: 'POST',
                body: JSON.stringify({
                    userName: localStorage.getItem("userEmail"),
                    bookName: localStorage.getItem("bookName"),
                    chosenBookName: chosenBookName,
                    newBookData: newBookData
                }),
                headers: {
                    'Content-Type': 'application/json',
                }
             })
            .then(response => {
                if(response.ok){
                  console.log("200 OK");
                    return response.json();
                }
                else{
                    return response.json().then((data)=>{
                         let errorMessage= 'מצטערים, אירעה שגיאה ';
                         if(data && data.error && data.error.message){ 
                         errorMessage = data.error.message; 
                         }
                         throw new Error(errorMessage);
                    });
                }
            }).then((data) => { 
              setBookPages(data.pages);
            });

        setPage("readBookPage");
      };
   

      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };

      const myGalleryHandler = () => {
          let url = "http://localhost:8080/booksCovers/" + localStorage.getItem("userEmail");
            fetch(url,
            {
                method: 'GET',
                body: null, 
                headers: {
                    'Content-Type': 'application/json',
                }
             })
            .then(response => {
                if(response.ok){
                  console.log("200 OK");
                    return response.json();
                }
                else{
                    return response.json().then((data)=>{
                         let errorMessage= 'מצטערים, אירעה שגיאה ';
                         if(data && data.error && data.error.message){ 
                         errorMessage = data.error.message; 
                         }
                         throw new Error(errorMessage);
                    });
                }
            }).then((data) => { 
              console.log(data);
        });

        setPage("galleryPage");
      };

      const adminPageHandler = () => {
        setPage("adminPage");
      };

      const galleryItemDeleteHandler = () =>
      {
      };

    
    return (
        <React.Fragment>
        <AuthContextProvider>

            {page === 'mainPage' && <MainPage 
             onBookItemClicked={bookItemClickedHandler} 
             onGalleryClicked={myGalleryHandler}
             onNotLoggedIn={notLoggedInHandler}
             onAdminPageClicked={adminPageHandler}/>}

            {page === 'createBookPage' && <CreateBookPage
            onBackToMainMenuButtonClicked={backButtonClickedHandler} 
            onCreateBook={createBookClickedHandler}/>} 

            {page === 'readBookPage' && <ReadBookPage bookPages={bookPages}
             bookName={bookName}
             onBackToMainMenuButtonClicked={backButtonClickedHandler}/>} 

            {page === 'galleryPage' && <GalleryPage items={dummyGalleryBooks} 
            onBackToMainMenuButtonClicked={backButtonClickedHandler} 
            onGalleryBookItemClicked={galleryBookItemClickedHandler}
            onGalleryItemDeletion={galleryItemDeleteHandler}/>} 

            {page === 'adminPage' && <AdminPage 
            onBackToMainMenuButtonClicked={backButtonClickedHandler} />} 


        </AuthContextProvider>
        </React.Fragment>
    )
}

export default App;