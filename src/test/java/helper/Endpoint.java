package helper;

public class Endpoint {

    public static final String HOST_DUMMY = "https://dummyapi.io/data/v1/";
    public static final String GET_LIST_USERS = HOST_DUMMY + "user";
    public static final String GET_LIST_USERS_ID = HOST_DUMMY + "user";

    public static final String CREATE_NEW_USERS = HOST_DUMMY + "user/create";
    public static final String DELETE_USERS = HOST_DUMMY + "user";
    public static final String POST_USERS = HOST_DUMMY + "user";

    public static final String PATCH_USERS = HOST_DUMMY + "user";
    public static final String PUT_USERS = HOST_DUMMY + "user";
    public static final String GET_ENDPOINT_WRONG = HOST_DUMMY + "userss";
    public static final String GET_DATA_WRONG_ID = HOST_DUMMY + "user" + "/" + "1234567";

}
