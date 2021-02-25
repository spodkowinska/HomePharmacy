package info.Podkowinski.HomePharmacy.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElse(null);
    }
//    public void deleteById(int id){
//        userRepository.deleteById(Long.valueOf(id));
//    }
}
