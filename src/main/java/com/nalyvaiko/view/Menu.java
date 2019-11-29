package com.nalyvaiko.view;

import com.nalyvaiko.entity.AuthorEntity;
import com.nalyvaiko.entity.BookCategoryEntity;
import com.nalyvaiko.entity.PublisherEntity;
import com.nalyvaiko.exception.NoSuchIdException;
import com.nalyvaiko.services.AuthorService;
import com.nalyvaiko.services.BookCategoryService;
import com.nalyvaiko.services.PublisherService;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private static Scanner input = new Scanner(System.in);

  public Menu() {
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("1", " 1 - Table: Author");
    menu.put("11", " 11 - Show all authors");
    menu.put("12", " 12 - Get author by id");
    menu.put("13", " 13 - Insert author");
    menu.put("14", " 14 - Update author");
    menu.put("15", " 15 - Delete author");

    menu.put("2", " 2 - Table: Publisher");
    menu.put("21", " 21 - Show all publishers");
    menu.put("22", " 22 - Get publisher by id");
    menu.put("23", " 23 - Insert publisher");
    menu.put("24", " 24 - Update publisher");
    menu.put("25", " 25 - Delete publisher");

    menu.put("3", " 3 - Table: BookCategory");
    menu.put("31", " 31 - Show all book categories");
    menu.put("32", " 32 - Get category by id");
    menu.put("33", " 33 - Insert book category");
    menu.put("34", " 34 - Update book category");
    menu.put("35", " 35 - Delete book category");

    menu.put("Q", " Q - Exit");

    methodsMenu.put("11", this::getAllAuthors);
    methodsMenu.put("12", this::getAuthorById);
    methodsMenu.put("13", this::insertAuthor);
    methodsMenu.put("14", this::updateAuthor);
    methodsMenu.put("15", this::deleteAuthor);

    methodsMenu.put("21", this::getAllPublishers);
    methodsMenu.put("22", this::getPublisherById);
    methodsMenu.put("23", this::insertPublisher);
    methodsMenu.put("24", this::updatePublisher);
    methodsMenu.put("25", this::deletePublisher);

    methodsMenu.put("31", this::getAllBookCategories);
    methodsMenu.put("32", this::getBookCategoryById);
    methodsMenu.put("33", this::insertBookCategory);
    methodsMenu.put("34", this::updateBookCategory);
    methodsMenu.put("35", this::deleteBookCategory);
  }

  private void getAllAuthors() throws SQLException {
    System.out.println("\nTable: Author");
    AuthorService authorService = new AuthorService();
    authorService.getAll().forEach(System.out::println);
  }

  private void getAuthorById() throws SQLException {
    System.out.println("Input ID for table Author: ");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    AuthorService authorService = new AuthorService();
    try {
      System.out.println(authorService.getAuthorById(id));
    } catch (NoSuchIdException e) {
      System.out.println(e.getMessage());
    }
  }

  private void insertAuthor() throws SQLException {
    System.out.println("Input last_name for Author");
    Scanner scanner = new Scanner(System.in);
    String last_name = scanner.nextLine();
    System.out
        .println("Input middle_name for Author if exist, otherwise - null");
    String middle_name = scanner.nextLine();
    System.out.println("Input first_name for Author");
    String first_name = scanner.nextLine();
    AuthorEntity entity;
    if (middle_name.equals("null")) {
      entity = new AuthorEntity(last_name, null, first_name);
    } else {
      entity = new AuthorEntity(last_name, middle_name, first_name);
    }
    AuthorService authorService = new AuthorService();
    System.out.println(
        "There are inserted " + authorService.insertAuthor(entity) + " rows");
  }

  private void updateAuthor() throws SQLException {
    System.out.println("Input ID for Author");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    System.out.println("Input last_name for Author");
    scanner = new Scanner(System.in);
    String last_name = scanner.nextLine();
    System.out
        .println("Input middle_name for Author if exist, otherwise - null");
    String middle_name = scanner.nextLine();
    System.out.println("Input first_name for Author");
    String first_name = scanner.nextLine();
    AuthorEntity entity;
    if (middle_name.equals("null")) {
      entity = new AuthorEntity(id, last_name, null, first_name);
    } else {
      entity = new AuthorEntity(id, last_name, middle_name, first_name);
    }
    AuthorService authorService = new AuthorService();
    System.out.println(
        "There are updated " + authorService.updateAuthor(entity) + " rows");
  }

  private void deleteAuthor() throws SQLException {
    System.out.println("Input ID for Author");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    AuthorEntity entity = new AuthorEntity();
    entity.setId(id);
    AuthorService authorService = new AuthorService();
    System.out.println(
        "There are deleted " + authorService.deleteAuthor(entity) + " rows");
  }

  private void getAllPublishers() throws SQLException {
    System.out.println("\nTable: Publisher");
    PublisherService publisherService = new PublisherService();
    publisherService.getAll().forEach(System.out::println);
  }

  private void getPublisherById() throws SQLException {
    System.out.println("Input ID for table Publisher: ");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    PublisherService publisherService = new PublisherService();
    System.out.println(publisherService.getPublisherById(id));
  }

  private void insertPublisher() throws SQLException {
    System.out.println("Input name for Publisher");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    PublisherEntity publisherEntity = new PublisherEntity();
    publisherEntity.setName(name);
    PublisherService publisherService = new PublisherService();
    System.out.println(
        "There are inserted " + publisherService
            .insertPublisher(publisherEntity) + " rows");
  }

  private void updatePublisher() throws SQLException {
    System.out.println("Input ID for Publisher");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    System.out.println("Input name for Publisher");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    PublisherEntity entity = new PublisherEntity(id, name);
    PublisherService publisherService = new PublisherService();
    System.out.println(
        "There are updated " + publisherService.updatePublisher(entity)
            + " rows");
  }

  private void deletePublisher() throws SQLException {
    System.out.println("Input ID for Publisher");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    PublisherEntity entity = new PublisherEntity();
    entity.setId(id);
    PublisherService publisherService = new PublisherService();
    System.out.println(
        "There are deleted " + publisherService.deletePublisher(entity)
            + " rows");
  }

  private void getAllBookCategories() throws SQLException {
    System.out.println("\nTable: BookCategory");
    BookCategoryService bookCategoryService = new BookCategoryService();
    bookCategoryService.getAll().forEach(System.out::println);
  }

  private void getBookCategoryById() throws SQLException {
    System.out.println("Input ID for table BookCategory: ");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    BookCategoryService bookCategoryService = new BookCategoryService();
    System.out.println(bookCategoryService.getBookCategoryById(id));
  }

  private void insertBookCategory() throws SQLException {
    System.out.println("Input name for BookCategory");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    BookCategoryEntity bookCategoryEntity = new BookCategoryEntity();
    bookCategoryEntity.setName(name);
    BookCategoryService bookCategoryService = new BookCategoryService();
    System.out.println(
        "There are inserted " + bookCategoryService
            .insertBookCategory(bookCategoryEntity) + " rows");
  }

  private void updateBookCategory() throws SQLException {
    System.out.println("Input ID for BookCategory");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    System.out.println("Input name for BookCategory");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    BookCategoryEntity bookCategoryEntity = new BookCategoryEntity(id, name);
    BookCategoryService bookCategoryService = new BookCategoryService();
    System.out.println(
        "There are updated " + bookCategoryService
            .updateBookCategory(bookCategoryEntity) + " rows");
  }

  private void deleteBookCategory() throws SQLException {
    System.out.println("Input ID for BookCategory");
    Scanner scanner = new Scanner(System.in);
    Integer id = scanner.nextInt();
    BookCategoryEntity entity = new BookCategoryEntity();
    entity.setId(id);
    BookCategoryService bookCategoryService = new BookCategoryService();
    System.out.println(
        "There are deleted " + bookCategoryService
            .deleteBookCategory(entity) + " rows");
  }

  private void outputMenu() {
    System.out.println("\nMENU:");
    for (String key : menu.keySet()) {
      if (key.length() == 1) {
        System.out.println(menu.get(key));
      }
    }
  }

  private void outputSubMenu(String fig) {
    System.out.println("\nSubMENU:");
    for (String key : menu.keySet()) {
      if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
        System.out.println(menu.get(key));
      }
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();

      if (keyMenu.matches("^\\d")) {
        outputSubMenu(keyMenu);
        System.out.println("Please, select menu point.");
        keyMenu = input.nextLine().toUpperCase();
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception e) {
      }
    } while (!keyMenu.equals("Q"));
  }
}
