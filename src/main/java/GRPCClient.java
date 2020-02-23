import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.User;
import org.example.grpc.userGrpc;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        //Stubs - generate from proto file;

       userGrpc.userBlockingStub userStrub  = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("Hello").setPassword("Hello").build();
        User.APIResponse apiResponse = userStrub.login(loginRequest);
        System.out.println(apiResponse.getResponseMessage());
    }
}
