/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.project.repositories;

import com.group.project.models.SavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mhtso
 */
@Repository
public interface SavedRepo extends JpaRepository<SavedRecipes, Integer> {

}