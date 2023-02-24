package udemy.burns.udemy_spring.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity //needed to convert to an entity in JPA and hibernate knows
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> Books = new HashSet<>();

    public Author() {
        //JPA required zero argument constructor
    }

    public Author(String firstName, String lastName)
                  //Set<book> books)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Books = Books;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Book> getBooks() {
        return Books;
    }

    public void setBooks(Set<Book> Books) {
        this.Books = Books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //to string method

    @Override
    public String toString() {
        return "author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                //", books=" + books +
                '}';
    }

    //hashing and equals code functions

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
