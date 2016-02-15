package be.kdg.kandoe.frontend.controllers.resources.errors;

public class ErrorResource
{
    private final String errorMessage;

    public ErrorResource(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
}
