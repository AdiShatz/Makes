import React from "react";
import BookItem from "./BookItem"
import './BooksList.css'



const BooksList = (props) => {

      return (
        <div className='books-list'>
          {props.items.map((book) => (
            <BookItem
              key={book.id}
              id={book.id}
              name={book.name}
              coverPhoto={book.coverPhoto}
              onBookItemClicked={props.onBookItemClicked}
              onGalleryBookItemClicked={props.onGalleryBookItemClicked}
              isGalleryItem= {props.isGalleryItem}
              //onGalleryItemDeletion={props.onGalleryItemDeletion}
            />
          ))}
          </div>
      );
    }

export default BooksList;
