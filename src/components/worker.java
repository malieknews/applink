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
