import React, {useState, useEffect} from "react";
import BookItem from "./BookItem"
import './BooksList.css'



const BooksList = (props) => {

  const [bookCovers, setBookCovers] = useState([]);

  useEffect(
      () => {
        setBookCovers(props.items);
      },[props]
  );

      return (
        <div className='books-list'>
          {bookCovers.length===0 && 
          <div>
            <h1>!הגלרייה ריקה</h1>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
          <p className="par">אופס.. ניראה שעדיין לא שמרת סיפור בגלרייה,
           חזור לדף הראשי, וצור סיפור מותאם אישית </p>
          </div>}
          {bookCovers && bookCovers.map((book) => (
            <BookItem
              name={book.owner==="Admin" ? book.templateName : book.bookName}
              bookId = {book.bookId}
              coverPhoto={book.coverPhoto}
              onBookItemClicked={props.onBookItemClicked}
              onNotLoggedIn={props.onNotLoggedIn}
              onGalleryBookItemClicked={props.onGalleryBookItemClicked}
              isGalleryItem= {props.isGalleryItem}
              onGalleryItemDeletion={props.onGalleryItemDeletion}
            />
          ))}
          </div>
      );
    }

export default BooksList;
