package com.example.demo.Controller;

import com.example.demo.Domain.*;
import com.example.demo.Factory.*;
import com.example.demo.Repository.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * Created by Adeebo on 2017/08/20.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/Controller")
public class MainController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;
    @Autowired
    private AssetRegisterRepository assetRegisterRepository;
    @Autowired
    private WagesRepository wagesRepository;

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Add services
    @GetMapping(path = "/addNewUser") // Map ONLY GET Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);

         return new Gson().toJson(n);
        //return "Record Saved";
    }

    @GetMapping(path = "/addNewPlayer") // Map ONLY GET Requests
    public @ResponseBody String addNewPlayer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String DOB, @RequestParam String ID, @RequestParam String position, @RequestParam String strongFoot, @RequestParam String status) {

        Player player = PlayerFactory.buildPlayer(firstName, lastName, DOB, ID, position, strongFoot, status);

        playerRepository.save(player);

        return new Gson().toJson(player);
        //return "Record Saved";

    }

    @GetMapping(path = "/addNewCoach") // Map ONLY GET Requests
    public @ResponseBody String addNewCoach(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String DOB, @RequestParam String status) {

        Coach coach = CoachFactory.buildCoach(firstName, lastName, DOB, status);

        coachRepository.save(coach);

        return new Gson().toJson(coach);
        //return "Record Saved";
    }

    @GetMapping(path = "/addNewAdministrator") // Map ONLY GET Requests
    public @ResponseBody String addNewAdministrator(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String designation, @RequestParam String DOB, @RequestParam String status) {

        Administrator admin = AdministratorFactory.buildAdministrator(firstName, lastName, designation, DOB, status);
        UserRoles user = UserRolesFactory.buildUserRoles(designation, admin.getClubID(), lastName, status);

        administratorRepository.save(admin);
        userRolesRepository.save(user);

        return new Gson().toJson(admin);
        // "Record Saved";
    }

    @GetMapping(path = "/addNewWages") // Map ONLY GET Requests
    public @ResponseBody String addNewWages(@RequestParam Integer wageID,@RequestParam Integer clubID,@RequestParam Integer level,@RequestParam String firstName,@RequestParam String lastName,@RequestParam float amount) {

        Wages wage = WagesFactory.buildWages(wageID,clubID,level,firstName,lastName,amount);

        wagesRepository.save(wage);

        return new Gson().toJson(wage);
        //return "Record Saved";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Update services
    @GetMapping(path = "/updateUser") // Map ONLY GET Requests
    public @ResponseBody String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {

        User n = userRepository.findOne(id);

        if (n != null) {

            n.setName(name);
            n.setEmail(email);
            userRepository.save(n);

            return "User Record updated";

        } else

            return "User Record not updated!";
    }

    @GetMapping(path = "/updatePlayer") // Map ONLY GET Requests
    public @ResponseBody String updatePlayer(@RequestParam Integer clubID, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String DOB, @RequestParam String ID, @RequestParam String position, @RequestParam String strongFoot, @RequestParam String status) {

        Player p = playerRepository.findOne(clubID);

        if (p != null) {

            Player update = new Player.Builder()
                    .copy(p)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setDOB(DOB)
                    .setID(ID)
                    .setPosition(position)
                    .setStrongFoot(strongFoot)
                    .setStatus(status)
                    .build();

            playerRepository.save(update);

            return "Player Record updated";

        } else

            return "Player Record not updated!";
    }

    @GetMapping(path = "/updateCoach") // Map ONLY GET Requests
    public @ResponseBody String updateCoach(@RequestParam Integer clubID, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String DOB, @RequestParam String status) {

        Coach c = coachRepository.findOne(clubID);

        if (c != null) {

            Coach update = new Coach.Builder()
                    .copy(c)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setDOB(DOB)
                    .setStatus(status)
                    .build();

            coachRepository.save(update);

            return "Coach Record updated";

        } else

            return "Coach Record not updated!";
    }

    @GetMapping(path = "/updateAdministrator") // Map ONLY GET Requests
    public @ResponseBody String updateAdministrator(@RequestParam Integer clubID, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String designation, @RequestParam String DOB, @RequestParam String status) {

        Administrator a = administratorRepository.findOne(clubID);
        UserRoles u = userRolesRepository.findOne(clubID);

        if (a != null) {

            Administrator update = new Administrator.Builder()
                    .copy(a)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setDesignation(designation)
                    .setDOB(DOB)
                    .setStatus(status)
                    .build();

            UserRoles userU = new UserRoles.Builder()
                    .copy(u)
                    .setRole(designation)
                    .setClubID(clubID)
                    .setPassword(lastName)
                    .setStatus(status)
                    .build();

            administratorRepository.save(update);
            userRolesRepository.save(userU);

            return "Administrator Record updated";

        } else

            return "Administrator Record not updated!";
    }

    @GetMapping(path = "/updateWages") // Map ONLY GET Requests
    public @ResponseBody String updateWages(@RequestParam Integer wageID,@RequestParam Integer clubID,@RequestParam Integer level,@RequestParam String firstName,@RequestParam String lastName,@RequestParam float amount) {

        Wages w = wagesRepository.findOne(clubID);

        if (w != null) {

            Wages update = new Wages.Builder()
                    .copy(w)
                    .setClubID(clubID)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setAmount(amount)
                    .build();

            wagesRepository.save(update);

            return "Wages Record updated";

        } else

            return "Record not updated!";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Search services
    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping(path = "/oneUser")
    public @ResponseBody String getSingleUser(@RequestParam Long id) {

        User user = userRepository.findOne(id);

        return user.toString();
    }

    @GetMapping(path = "/allPlayers")
    public @ResponseBody Iterable<Player> getAllPlayers() {

        return playerRepository.findAll();
    }

    @GetMapping(path = "/onePlayer")
    public @ResponseBody String getSinglePlayer(@RequestParam Integer clubID) {

        Player player = playerRepository.findOne(clubID);

        return player.toString();
    }

    @GetMapping(path = "/allCoachs")
    public @ResponseBody Iterable<Coach> getAllCoachs() {

        return coachRepository.findAll();
    }

    @GetMapping(path = "/oneCoach")
    public @ResponseBody String getSingleCoach(@RequestParam Integer clubID) {

        Coach coach = coachRepository.findOne(clubID);

        return coach.toString();
    }

    @GetMapping(path = "/allAdministrator")
    public @ResponseBody Iterable<Administrator> getAllAdministrators() {

        return administratorRepository.findAll();
    }

    @GetMapping(path = "/oneAdministrator")
    public @ResponseBody String getSingleAdministrators(@RequestParam Integer clubID) {

        Administrator admin = administratorRepository.findOne(clubID);

        return admin.toString();
    }

    @GetMapping(path = "/oneWage")
    public @ResponseBody String getSingleWage(@RequestParam Integer clubID) {

        Wages wage = wagesRepository.findOne(clubID);

        return wage.toString();
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Delete services
    @GetMapping(path = "/deleteAdministrator")
    public @ResponseBody String deleteAdmin(@RequestParam Integer clubID) {

        Administrator adminDelete = administratorRepository.findOne(clubID);
        UserRoles userRoleDelete = userRolesRepository.findOne(clubID);

        if (adminDelete != null) {
            Administrator adminUpdate = new Administrator.Builder()
                    .copy(adminDelete)
                    .setStatus("inactive")
                    .build();
            UserRoles userRolesUpdate = new UserRoles.Builder()
                    .copy(userRoleDelete)
                    .setStatus("inactive")
                    .build();

            administratorRepository.save(adminUpdate); //Records are not deleted. They are set to inactive
            userRolesRepository.save(userRolesUpdate); //Update roles table

            return "Administrator " + adminDelete.getFirstName().toUpperCase() + " " + adminDelete.getLastName().toUpperCase() + " deleted";

        } else

            return "No Administrator to delete";
    }

    @GetMapping(path = "/deletePlayer")
    public @ResponseBody String deletePlayer(@RequestParam Integer clubID) {

        Player delete = playerRepository.findOne(clubID);

        if (delete != null) {
            Player update = new Player.Builder()
                    .copy(delete)
                    .setStatus("inactive")
                    .build();

            playerRepository.save(update); //Records are not deleted. They are set to inactive

            return "Player " + delete.getFirstName().toUpperCase() + " " + delete.getLastName().toUpperCase() + " deleted";

        } else

            return "No Player to delete";
    }

    @GetMapping(path = "/deleteCoach")
    public @ResponseBody String deleteCoach(@RequestParam Integer clubID) {

        Coach delete = coachRepository.findOne(clubID);

        if (delete != null) {
            Coach update = new Coach.Builder()
                    .copy(delete)
                    .setStatus("inactive")
                    .build();

            coachRepository.save(update); //Records are not deleted. They are set to inactive

            return "Coach " + delete.getFirstName().toUpperCase() + " " + delete.getLastName().toUpperCase() + " deleted";

        } else

            return "No Coach to delete";
    }

    @GetMapping(path = "/deleteWage")
    public @ResponseBody String deleteWage(@RequestParam Integer clubID) {

        Wages delete = wagesRepository.findOne(clubID);

        if (delete != null) {

            wagesRepository.delete(delete);

            return "Wage for " + delete.getFirstName().toUpperCase() + " " + delete.getLastName().toUpperCase() + " deleted";

        } else

            return "No Wages to delete";
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Add assets
    //@DateTimeFormat(pattern = "MM/dd/yyyy") Date date
    @GetMapping(path = "/addNewAsset") // Map ONLY GET Requests
    public @ResponseBody String addNewAsset(@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,@RequestParam String assetName, @RequestParam String assetDescription, @RequestParam float assetValue, @RequestParam int assetQuantity, @RequestParam String assetState) {

        AssetRegister ar = AssetRegisterFactory.buildAssetRegister(date, assetName, assetDescription, assetValue, assetQuantity, assetState);

        assetRegisterRepository.save(ar);
        return "Asset Record Saved";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Update services
    @GetMapping(path = "/updateAsset") // Map ONLY GET Requests
    public @ResponseBody String updateAsset(@RequestParam Integer assetID, @RequestParam Date date, @RequestParam String assetName, @RequestParam String assetDescription, @RequestParam float assetValue, @RequestParam int assetQuantity, @RequestParam String assetState) {

        AssetRegister ar = assetRegisterRepository.findOne(assetID);

        if (ar != null) {

            AssetRegister assetUpdate = new AssetRegister.Builder()
                    .copy(ar)
                    .setDate(date)
                    .setAssetName(assetName)
                    .setAssetDescription(assetDescription)
                    .setAssetValue(assetValue)
                    .setAssetQuantity(assetQuantity)
                    .setAssetState(assetState)
                    .build();
            assetRegisterRepository.save(assetUpdate);

            return "AssetRegister Record updated";

        } else

            return "AssetRegister not updated!";
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Search services
    @GetMapping(path = "/allAssets")
    public @ResponseBody Iterable<AssetRegister> getAllAssets() {

        return assetRegisterRepository.findAll();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Delete services
    @GetMapping(path = "/deleteAssets")
    public @ResponseBody String deleteAssets(@RequestParam Integer clubID) {

        AssetRegister assetDelete = assetRegisterRepository.findOne(clubID);

        if (assetDelete != null) {
            AssetRegister adminUpdate = new AssetRegister.Builder()
                    .copy(assetDelete)
                    .setAssetState("inactive")
                    .build();

            assetRegisterRepository.save(adminUpdate); //Records are not deleted. They are set to inactive

            return "Deleted " + assetDelete.getAssetQuantity() + "x " + assetDelete.getAssetName().toUpperCase() + " items";

        } else

            return "No Assets to delete";
    }

}