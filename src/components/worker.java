// Initializes WorkManager.
class WorkManagerInitializer implements Initializer<WorkManager> {

    @Override
    public WorkManager create(Context context) {
        Configuration configuration = Configuration.Builder().build();
        WorkManager.initialize(context, configuration);
        return WorkManager.getInstance(context);
    }

    @Override
    public List<Class<Initializer<?>>> dependencies() {
        // No dependencies on other libraries.
        return emptyList();
    }

}
// Initializes ExampleLogger.
class ExampleLoggerInitializer implements Initializer<ExampleLogger> {

    @Override
    public ExampleLogger create(Context context) {
        // WorkManager.getInstance() is non-null only after
        // WorkManager is initialized.
        return ExampleLogger(WorkManager.getInstance(context));
    }

    @Override
    public List<Class<Initializer<?>>> dependencies() {
        // Defines a dependency on WorkManagerInitializer so it can be
        // initialized after WorkManager is initialized.
        return Arrays.asList(WorkManagerInitializer.class);
    }
}
