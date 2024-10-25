package com.Gruppuppgift.Cinema.Controller;

import com.Gruppuppgift.Cinema.DAO.AddressRepository;
import com.Gruppuppgift.Cinema.Entities.Address;
import com.Gruppuppgift.Cinema.Entities.Customer;
import com.Gruppuppgift.Cinema.Entities.Movie;
import com.Gruppuppgift.Cinema.Entities.Room;
import com.Gruppuppgift.Cinema.Service.AddressServiceImpl;
import com.Gruppuppgift.Cinema.Service.CustomerServiceImpl;
import com.Gruppuppgift.Cinema.Service.MovieServiceImpl;
import com.Gruppuppgift.Cinema.Service.RoomServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    private static final Logger logger = LogManager.getLogger("MyLogger");
    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer s) {
        logger.info("admin added customer " + s.getName());
        s.setId(0);
        Optional<Address> addressOptional = addressService.findById(s.getAddress().getId());
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            s.getAddress().setCity(address.getCity());
            s.getAddress().setPostalcode(address.getPostalcode());
            s.getAddress().setStreet(address.getStreet());
        }
        Customer customer =  customerService.saveCustomer(s);
        return customer;
    }


    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {return customerService.findAllCustomers();
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        logger.info("admin deleted customer with ID " + id);
        customerService.deleteCustomerById(id);
        return "kund med id " + id + " har raderats";
    }

    @PutMapping("customers/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer s){
        logger.info("admin updated customer with ID " + id);
        s.setId(id);
        Customer customer = customerService.saveCustomer(s);
        return customer;
    }
    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie){
        logger.info("admin added movie " + movie.getTitle());
        movie.setId(0);
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable int id) {
        logger.info("admin deleted movie with ID " + id);
        movieService.deleteMovieById(id);
        return "film med id " + id + " har raderats";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    @PutMapping("rooms/{id}")
    public Room updateRoom(@PathVariable int id, @RequestBody Room s){
        logger.info("admin updated room with ID " + id);
        s.setId(id);
        Room updatedRoom = roomService.saveRoom(s);
        return updatedRoom;
    }

}
