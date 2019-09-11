package com.qa.controllers;


import com.qa.controller.NotesController;
import com.qa.models.Note;
import com.qa.repository.NotesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotesControllerTest {

    @InjectMocks
    private NotesController notesController;

    @Mock
    private NotesRepository repository;


    @Test
    public void testGetAllNotes(){
        List<Note> notesList = new ArrayList<>();
        Note note = new Note();
        note.setDescription("blah");
        note.setName("Spanner");
        notesList.add(note);

        when(repository.findAll()).thenReturn(notesList);

        assertEquals(
                notesController.listAllNotes().get(0).getName(), "Spanner"
        );
        // assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/notes", List.class)).contains("sup la");

    }


    @Test
    public void testGetNote(){

        List<Note> notesList = new ArrayList<>();
        Note note = new Note();
        note.setDescription("blah");
        note.setName("Spanner");
        notesList.add(note);
        Note note1 = new Note();
        note1.setDescription("blah");
        note1.setName("davey");
        notesList.add(note1);

        when(repository.findOne(1l)).thenReturn(notesList.get(1));

        assertEquals(
                notesController.getNote(1l).getName(), "davey");

    }

    @Test
    public void testAddNote(){
        List<Note> notesList = new ArrayList<>();
        Note note = new Note();
        note.setDescription("blah");
        note.setName("dave");
        notesList.add(note);

        Note note1 = new Note();
        note1.setDescription("blah");
        note1.setName("Spanner");


        when(repository.saveAndFlush(note1)).thenReturn(note1);
        assertEquals(notesController.addNote(note1).getName(), "Spanner");
    }

    @Test
    public void testDeleteNote(){
        List<Note> notesList = new ArrayList<>();
        Note note = new Note();
        note.setDescription("blah");
        note.setName("dave");
        notesList.add(note);

        when(repository.findOne(0l)).thenReturn(notesList.get(0));
        assertEquals(
                notesController.deleteNote(0l).getName(), "dave");
    }
//    @Test
//    public void testGetOneNote(){
//        Note note = new Note();                   difference in inidexs, as ive used a list index starts at 0, if i hadnt the index doesnt matter
//        note.setName("blah");
//        when(repository.findOne(1L)).thenReturn(note);
//        assertEquals(notesController.getNote(1L).getName(), "blah" );
//    }
}
