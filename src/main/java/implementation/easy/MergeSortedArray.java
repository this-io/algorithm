package implementation.easy;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray a = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int n = 3;
        int[] nums2 = {2, 5, 6};

        String q = "Select Id\n" +
                ", ironclad__Workflow_ID__c\n" +
                ", Contract__c\n" +
                ", Contract__r.DocuSignEnvelopeStatus__c\n" +
                ", ironclad__Workflow_Type__c\n" +
                ", ironclad__Workflow_Status__c\n" +
                ", ironclad__Workflow_Name__c\n" +
                ", ironclad__Workflow_Link__c\n" +
                ", Opportunity__c \n" +
                "FROM ironclad__Ironclad_Workflow__c \n" +
                "WHERE ironclad__Workflow_Status__c = 'Sign'\n" +
                "AND Contract__r.DocuSignEnvelopeStatus__c = 'Completed'";
    }

}
