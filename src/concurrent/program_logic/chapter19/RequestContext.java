package concurrent.program_logic.chapter19;

public class RequestContext {
    public static class Request {

    };

    private static ThreadLocal<String> localUserId = new ThreadLocal<>();

    private static ThreadLocal<Request> localRequest = new ThreadLocal<>();

    public static String getCurrentUserId() {
        return localUserId.get();
    }

    public static void setCurrentUserId(String userId) {
        localUserId.set(userId);
    }

    public static void setCurrentRequest(Request request) {
        localRequest.set(request);
    }

    public static Request getCurrentRequest() {
        return localRequest.get();
    }
}
