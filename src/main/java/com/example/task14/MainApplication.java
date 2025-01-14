package com.example.task14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        NoteService noteService = context.getBean(NoteService.class);

        // Додавання нотаток
        Note note1 = new Note("Заголовок 1", "Контент 1");
        Note note2 = new Note("Заголовок 2", "Контент 2");

        noteService.add(note1);
        noteService.add(note2);

        // Виведення списку всіх нотаток
        System.out.println("Список всіх нотаток:");
        noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));

        // Оновлення нотатки
        Note updatedNote = new Note("Оновлений заголовок", "Оновлений контент");
        updatedNote.setId(note1.getId());
        noteService.update(updatedNote);

        System.out.println("\nСписок після оновлення:");
        noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));

        // Отримання нотатки за ідентифікатором
        System.out.println("\nОтримання нотатки за ідентифікатором:");
        Note retrievedNote = noteService.getById(note2.getId());
        System.out.println(retrievedNote.getTitle() + ": " + retrievedNote.getContent());

        // Видалення нотатки
        noteService.deleteById(note1.getId());

        System.out.println("\nСписок після видалення:");
        noteService.listAll().forEach(note -> System.out.println(note.getTitle() + ": " + note.getContent()));

        context.close();
    }
}