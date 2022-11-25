package org.openapitools.api;


import org.openapitools.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.Generated;

import static java.lang.Math.toIntExact;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-17T15:45:20.662336800+01:00[Europe/Berlin]")
@RestController
@RequestMapping("${openapi.swaggerPetstoreOpenAPI30.base-path:/api/v3}")
public class PetApiController implements PetApi {

    private final NativeWebRequest request;

    private final Map<Long, Pet> pets;

    @Autowired
    public PetApiController(NativeWebRequest request /*@Lazy PetApi petapi,*/) {
        this.request = request;
        pets = new HashMap<>();
        //this.petapi = petapi;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /*
     * Create Pet
     */
    @Override
    public ResponseEntity<Pet> addPet(Pet pet) {
        System.out.println("---addPet---\n");
        pets.put(pet.getId(),pet);
        System.out.println(pets.toString());
        return ResponseEntity.ok(pet);
    }

    /*
     * Get Pet
     */
    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        System.out.println("---getPetById---\n");
        return ResponseEntity.ok(pets.get(petId));
    }

    /*
     * Get all Pets
     */
    @Override
    public ResponseEntity<Map> getAllPets() {
        System.out.println("---getAllPets---\n");
        return ResponseEntity.ok(pets);
    }

    /*
     * Update all Pets
     */
    @Override
    public ResponseEntity<Pet> updatePet(Pet pet) {
        System.out.println("---updatePet---\n");
        if(!pets.isEmpty()) {
            for (Map.Entry<Long, Pet> entry: pets.entrySet()) {
                //if (pet.equals(entry.getValue())) {
                    pets.put(entry.getKey(), pet);
                //}
            }
        } else System.out.println("TODO");
        return ResponseEntity.ok(pet);
    }

    /*
     * Delete a Pet
     */
    @Override
    public ResponseEntity<Void> deletePet(Long petId) {
        System.out.println("---deletePet---\n");
        pets.remove(petId);
        return ResponseEntity.noContent().build();
    }

}
