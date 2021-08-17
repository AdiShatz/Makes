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
          {bookCovers && bookCovers.map((book) => (
            <BookItem
              name={book.name}
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
