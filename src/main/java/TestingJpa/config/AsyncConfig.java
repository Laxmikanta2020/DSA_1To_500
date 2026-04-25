//package TestingJpa.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
//@Configuration
//@EnableAsync
//public class AsyncConfig {
//
//    @Bean("LAXMI")
//    Executor executor() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(10);
//        threadPoolTaskExecutor.setMaxPoolSize(10);
//        threadPoolTaskExecutor.setQueueCapacity(20);
//        threadPoolTaskExecutor.setThreadNamePrefix("LAXMI-");  // ADDED: For debugging
//
//        // ADDED: Graceful shutdown
//        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
//
//        // ADDED: What to do when queue is full
////        threadPoolTaskExecutor.setRejectedExecutionHandler(
////                new ThreadPoolTaskExecutor.CallerRunsPolicy()
////        );
//
//        threadPoolTaskExecutor.initialize();
//        return threadPoolTaskExecutor;
//
//    }
//}
////With Virtual Threads:
////javaExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
////for (int i = 0; i < 1000000; i++) {
////    executor.submit(() -> makeHttpCall()); // Millions of tasks easily handled
////}