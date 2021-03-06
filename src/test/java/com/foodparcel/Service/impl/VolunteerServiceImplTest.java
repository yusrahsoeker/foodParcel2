package com.foodparcel.Service.impl;

import com.foodparcel.Repository.VolunteerRepository;
import com.foodparcel.Service.VolunteerService;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.factory.VolunteerFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Mncedisi Mngadi
 * 214210286
 * 3B
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VolunteerServiceImplTest {

    @Autowired
    private static VolunteerService service;
    private static Volunteer volunteer = VolunteerFactory.builderVolunteer("Mncedisi","Mngadi",+27021515,9651511);

    @Test
    public void a_create() {

        Volunteer created = service.create(volunteer);
        assertEquals(volunteer.getVolunteerNum(), created.getVolunteerNum());
        System.out.println("Created: "+created);


    }

    @Test
    public void b_read() {

        Volunteer read = service.read(volunteer.getVolunteerNum());
        assertNotNull(read);
        System.out.println("Read: "+read);

    }

    @Test
    public void c_update() {

        Volunteer updated = new Volunteer.Builder().copy(volunteer).setFirstName("John").build();
        updated = service.update(updated);
        assertNotEquals(updated, volunteer);
        System.out.println("Updated: "+updated);

    }

    @Test
    public void d_getAll() {

        Set<Volunteer> volunteers = service.getAll();
        assertEquals(1,volunteers.size());
        System.out.println("These are all Volunteers: "+volunteers);

    }

    @Test
    public void e_isAvailable(){

        Volunteer availability = new Volunteer.Builder().copy(volunteer).setAvailability(true).build();
        //availability = service.isAvailable(availability);
        assertNotSame(availability, volunteer);
        System.out.println("Before availability update: "+volunteer);
        System.out.println("after availability Updated: "+availability);

    }

    @Test
    public void f_delete1() {

        boolean deleted  = service.delete1(volunteer.getVolunteerNum());
        Assert.assertTrue(deleted);
        System.out.println("Deleted: "+volunteer);

    }
}