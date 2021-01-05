package com.example.techgo;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Vector;


class User {
    public String username;
    public String email;
    public String password;
    public String confirmPassword;
    private int totalRide;
    private boolean rideStatus;
    private int wallet;
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email,String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.password = password;
        totalRide = 0;
        rideStatus = false;
        wallet = 0;
    }

    public String GetUserID(DatabaseReference ref){
        DatabaseReference userRef = ref.child("user");
        String key = userRef.push().getKey();
        return key;
    }

    public Vector<String> CreateAccount(DatabaseReference ref){
        ValidatorAccount validatorUser = new ValidatorAccount();
        final Vector<String> error = validatorUser.Validator(email,password,confirmPassword,username);
        if (error.size() == 0){
            ref.child("users").orderByChild("email").equalTo(email)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (!dataSnapshot.exists()){
                                //Display UI about "User was registered" notifications to the user
                                error.add("User was registered");
                            }else{
                                // Display UI about successful
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            ref.child("users").child(GetUserID(ref)).setValue(this);
        }else{
            //Display UI about error notifications to the user
            return error;
        }
        return error;
    }

    public String toString(){
        return username + ":" + password;
    }
}



