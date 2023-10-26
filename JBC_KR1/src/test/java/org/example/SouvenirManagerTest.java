package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SouvenirManagerTest {

    private SouvenirManager souvenirManager;

    @BeforeEach
    public void setUp() {
        souvenirManager = new SouvenirManager();
    }

    @Test
    @Disabled
    public void testAddSouvenir() {
        souvenirManager.addSouvenir("Test Souvenir", "Test Manufacturer", "2023-10-24", "19.99");
        assertEquals(1, souvenirManager.getSouvenirs().size());
    }

   @Test
    @Disabled
    public void testAddManufacturer() {
        souvenirManager.addManufacturer("Test Manufacturer", "Test Country");
        assertEquals(1, souvenirManager.getManufacturers().size());
    }

    @Test
    @Disabled
    public void testEditSouvenir() {
        souvenirManager.addSouvenir("Test Souvenir", "Test Manufacturer", "2023-10-24", "19.99");
        souvenirManager.editSouvenir("Test Souvenir", "Test Manufacturer", "29.99");
        assertEquals("29.99", souvenirManager.getSouvenirs().get(0).getPrice());
    }

    @Test
    @Disabled
    public void testDeleteManufacturer() {
        souvenirManager.addManufacturer("Test Manufacturer", "Test Country");
        souvenirManager.addSouvenir("Test Souvenir", "Test Manufacturer", "2023-10-24", "19.99");
        souvenirManager.deleteManufacturer("Test Manufacturer");
        assertEquals(0, souvenirManager.getManufacturers().size());
        assertEquals(0, souvenirManager.getSouvenirs().size());
    }

}