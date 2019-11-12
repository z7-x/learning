package com.example.springboot.controller;
import com.example.springboot.pojo.BookModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @RequestMapping("/books")
    public String bookString(ModelMap model) {
        List<BookModel> bookModelList = new ArrayList<>();

        BookModel bookModel = new BookModel();
        bookModel.setId(1);
        bookModel.setName("三国演义2");
        bookModel.setAuthor("罗贯中2");
        bookModelList.add(bookModel);

        BookModel bookModel2 = new BookModel();
        bookModel2.setId(2);
        bookModel2.setName("红楼梦2");
        bookModel2.setAuthor("曹雪芹2");
        bookModelList.add(bookModel2);

        model.addAttribute("books", bookModelList);
        return "model_books";//返回逻辑名：model_books.html
    }

    @RequestMapping("/josnBooks")
    public BookModel book(){
        BookModel book = new BookModel();
        book.setId(1);
        book.setName("三国演义1");
        book.setAuthor("罗贯中77777");
        book.setPrice(30f);
        book.setCreateDate(new Date());
        return book;
    }
}
