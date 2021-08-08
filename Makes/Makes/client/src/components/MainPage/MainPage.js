import React, {useEffect, useContext, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import AuthForm from "../Auth/AuthForm";
import AuthContext from "../../store/auth-context";
import useHttp from "../../hooks/use-http";
import './MainPage.css';
import '../UI/Header.css'
import '../UI/Footer.css'

const MainPage = (props) => {

  const authCtx = useContext(AuthContext);
  const isLoggedIn = authCtx.isLoggedIn;
  const username = authCtx.username;  
  const isAdminUser = authCtx.username==="nirolol1994@gmail.com" || authCtx.username==="lilach.birnbaum@gmail.com";  
  

  const [bookCards, setBookCards] = useState([]);
  const [loginFormIsShown, setLoginFormIsShown] = useState(false);
  
    const transformedBooks = booksArr => {
      const loadedBooks=[];
      booksArr.forEach(book =>  loadedBooks.push({name: book.name, coverPhoto: book.coverPhoto}));
    setBookCards(loadedBooks);
    };

    const {isLoading, error, sendRequest: fetchBooks} = 
    useHttp({url: 'http://localhost:8080/booksCovers/'},
    transformedBooks
    );

    useEffect(()=>{
      fetchBooks();
    },[]);



    const showLoginFormHandler = () => {
      setLoginFormIsShown(true);
    };
  
    const hideLoginFormHandler = () => {
      setLoginFormIsShown(false);
    };

    const logoutHandler = () => {
        authCtx.logout();
      };

    return (
        <div >
            {loginFormIsShown && <AuthForm onClose={hideLoginFormHandler} />}
            <Header className="header">
            <nav>
                <ul>
                 <li>{!isLoggedIn && <Button className="login-button" type="input" onClick={showLoginFormHandler}>התחבר</Button>}</li>
                 <li><label> שלום {username} </label></li>
                </ul>
            </nav>
            </Header>
            {isLoading && <h1>...אנא המתן</h1>}
            {!isLoading &&  <MainPageContent 
             items={props.items}
             onBookItemClicked={props.onBookItemClicked}
             onNotLoggedIn={props.onNotLoggedIn}
             items={bookCards}/>}
            <Footer>
            {isLoggedIn &&<Button type="button" onClick={logoutHandler}>התנתק</Button>}
           {isLoggedIn && <Button type="button" onClick={props.onGalleryClicked}>הגלריה שלי</Button>}
           {isAdminUser && <label onClick= {props.onAdminPageClicked}>ניהול ספרים</label>}
            </Footer>
        </div>
    );
}
export default MainPage;