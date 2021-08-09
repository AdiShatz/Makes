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

    const authCtx = useContext(AuthContext);

    const isLoggedIn = authCtx.isLoggedIn;

    const [page, setPage] = useState("mainPage");
    const [dummyGalleryBooks, setDummyBooks] = useState(DUMMY_GALLERY_BOOKS); // TO CHANGE

    // const isAdminUser = () => {
    //   if(localStorage.getItem.name)==
    // }

    const bookItemClickedHandler = () => {
      setPage("createBookPage");
    };

    const notLoggedInHandler = (book) => {
    alert("אנא התחבר על מנת להשלים את הפעולה");
  };


    const galleryBookItemClickedHandler = () => {
      setPage("readBookPage");
    };

      const createBookClickedHandler = (event) => {
         console.log(event.target);
          // const enteredEmail = emailInputRef.current.value;
          // const enteredPassword = passwordInputRef.current.value;
          let url;
          
          // setIsLoading(true);

          //TODO
          url = "https://localhost8080???????????";
            fetch(url,
            {
                method: 'POST',
                body: JSON.stringify({
                    email: "nir",
                    password: "1234",
                    returnsecureToken: true
                }),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                // setIsLoading(false);
                if(res.ok){
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
            });
            // .then((data) => { 
            //  authCtx.login(data.idToken, data.email);
            // })
            // .catch(err => {
            // alert(err.message);
            // }).then(isLogin?props.onClose:switchAuthModeHandler);
            
        
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