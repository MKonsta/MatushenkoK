package ru.job4j.servlets.webarchitecturejsp.logic;

import ru.job4j.servlets.webarchitecturejsp.model.User;

import java.util.List;

/**
 * В данном классе для работы с базой пользователей во всех методах проходит сначала валидация данных,
 * а затем используются методы из класса ValidateService
 */
public class ValidateService {

    //==========================Singletone======================================
    private static ValidateService validateService;

    public static synchronized ValidateService getValidateService() {
        if (validateService == null) {
            validateService = new ValidateService();
        }
        return validateService;
    }

    private ValidateService() {
    }
    //============================================================================


    //==============Методы для проверки(валидации) MemoryStore (используется ConcurrentHashMap)===================

    /**
     * Вспомогательный метод для проверки - есть ли уже в мапе пользователи с заданными именем и email'ом
     * Данный метод используется в методе add(User user) данного класса
     *
     * @param email
     * @param login
     * @return
     */
    private boolean addValid(String email, String login) {
        boolean res = true;
        for (User user : DBStore.getInstance().findAll()) {
            if (user.getEmail().equals(email) || user.getLogin().equals(login)) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * Вспомогательный метод для валидации данных при редактировании пользователя
     *
     * @param id
     * @param email
     * @param login
     * @return
     */
    private boolean updateValid(int id, String email, String login) {
        boolean res = true;
        for (User user : DBStore.getInstance().findAll()) {
            if (user.getEmail().equals(email) && user.getId() != id
                    || user.getLogin().equals(login) && user.getId() != id) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * Метод для добавления пользователя. Вначале проходит валидация с помощью метода addValid.
     * И если валидация пройдена, вызывается метод addUser из класса MemoryStore, который добавляет юзера в мапу
     *
     * @param user
     * @return
     */
    public boolean add(User user) {
        if (addValid(user.getEmail(), user.getLogin())) {
            DBStore.getInstance().addUser(user);
            return true;
        }
        return false;
    }

    /**
     * Метод для обновления данных пользователя. Сначала проходит валидация
     *
     * @param id
     * @param user
     * @return
     */
    public boolean update(int id, User user) {
        for (User user1 : DBStore.getInstance().findAll()) {
            if (user1.getId() == id) {
                if (updateValid(id, user.getEmail(), user.getLogin())) {
                    DBStore.getInstance().updateUser(id, user);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод для удаления пользователя. Вначале проверяет, существует ли пользователь с заданным id
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        boolean res = false;
        for (User user : DBStore.getInstance().findAll()) {
            if (user.getId() == id) {
                DBStore.getInstance().deleteUser(id);
                res = true;
            }
        }
        return res;
    }

    /**
     * Метод возвращает список всех пользователей. Сначала проверяет, есть ли в мапе хотябы 1 пользователь
     * @return
     */
    public List<User> findAll () {
        if (DBStore.getInstance().findAll().size() > 0) {
            return DBStore.getInstance().findAll();
        }
        return null;
    }

    /**
     * Метод поиска пользователя по id. Сначала проверяет, существует ли пользователь с заданным id
     * @param id
     * @return
     */
    public User findById (int id){
        for (User user : DBStore.getInstance().findAll()) {
            if (user.getId() == id) {
                return DBStore.getInstance().findById(id);
            }
        }
        return null;
    }

}