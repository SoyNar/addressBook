public class Contact {

    private String name;
    private String phone;
    private  String email;

    private Contact(Builder builder)
    {
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static  class Builder{

        private String name;
        private String phone;
        private  String email;



        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return  this;
        }


        public Builder email(String email){
            this.email = email;
            return  this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}
