import React, {useState, useContext} from "react";
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

      const createBookClickedHandler = (newBookData) => {

        //  const bookData = {
        //    userName: localStorage.getItem("userName"),
        //    bookName: localStorage.getItem("chosenBookName"),
        //    newBookData
        //  };

        //  console.log(bookData);

          // const enteredEmail = emailInputRef.current.value;
          // const enteredPassword = passwordInputRef.current.value;
         
          
          // setIsLoading(true);

          //TODO
          url = "http://localhost:8080/customBooks/"

            fetch(url,
            {
                method: 'POST',
                body: JSON.stringify({
                    userName: localStorage.getItem("userName"),
                    bookName: localStorage.getItem("chosenBookName"),
                    newBookData: newBookData
                }),
                headers: {
                    'Content-Type': 'application/json',
                }
             })
            .then(res => {
                // setIsLoading(false);
                if(res.ok){
                  console.log("200 OK");
                    return res.json();
                }
                else{
                    return res.json().then((data)=>{
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
        setPage("readBookPage");
      };
    
      const backButtonClickedHandler = () => {
        setPage("mainPage");
      };

      const myGalleryHandler = () => {
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

            {page === 'readBookPage' && <ReadBookPage
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