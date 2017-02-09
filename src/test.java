/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */
import java.io.Serializable;

public class test {




	/**
	 * This class will represent the Model.
	 */
	public class Automotive implements Serializable {
	    private String name;
	    private float basePrice;
	    private OptionSet opset[];

	    private static final long serialVersionUID = -8916455215110924782L;

	    public Automotive() {
	        name = null;
	        basePrice = 0.0f;
	        opset = null;
	    }

	    public Automotive(String name, float basePrice, int size) {
	        this.name = name;
	        this.basePrice = basePrice;
	        this.opset = new OptionSet[size];

	        for (int i = 0; i < size; i++) {
	            opset[i] = new OptionSet();
	        }
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public float getBasePrice() {
	        return basePrice;
	    }

	    public OptionSet getOpset(int index) {
	        return opset[index];
	    }

	    public OptionSet[] getOpset() {
	        return opset;
	    }

	    // Setters

	    public void setName(String name) {
	        this.name = name;
	    }


	    public void setBasePrice(float basePrice) {
	        this.basePrice = basePrice;
	    }

	    public void setOpset(int index, OptionSet opset) {
	        this.opset[index] = opset;
	    }

	    public void setOpset(OptionSet[] opset) {
	        this.opset = opset;
	    }

	    public void setOption(int i, int j, OptionSet.Option option) {
	        this.opset[i].setOpt(j, option);
	    }

	    @Override
	    public String toString() {
	        StringBuilder result = new StringBuilder();
	        result.append("name: ").append(name).append('\n');
	        result.append("base_price: ").append(basePrice).append('\n');
	        result.append("opset: [\n");

	        for (OptionSet optionSet : opset) {
	            result.append(optionSet.toString()).append('\n');
	        }

	        
	        return result.toString();
	    }

	    /**
	     * Find an OptionSet.
	     *
	     * @param name the name of the OptionSet
	     * @return the index of the OptionSet, -1 if not found
	     */
	    public int findOptionSet(String name) {
	        if (name == null || name.isEmpty()) return -1;

	        for (int i = 0; i < opset.length; ++i) {
	            if (name.equals(opset[i].getName())) {
	                return i;
	            }
	        }
	        return -1;
	    }


	    /**
	     * Delete an OptionSet.
	     *
	     * @param name the name of the OptionSet
	     * @return the deleted OptionSet, null if not found
	     */
	    public OptionSet deleteOptionSet(String name) {
	        final int index = findOptionSet(name);
	        if (index < 0) return null;

	        final OptionSet deleted = opset[index];

	        final OptionSet[] newOpset = new OptionSet[opset.length - 1];

	        // Copy values into a new array
	        int i = 0;
	        for (int j = 0; j < opset.length; ++j) {
	            if (j != index) {
	                newOpset[i++] = opset[j];
	            }
	        }
	        this.opset = newOpset;

	        return deleted;
	    }

	    /**
	     * Delete an Option.
	     *
	     * @param name the name of the Option
	     * @return the deleted Option, null if not found
	     */
	    public OptionSet.Option deleteOption(String name) {
	        for (final OptionSet optionSet : opset) {
	            final OptionSet.Option deleted = optionSet.deleteOption(name);
	            if (deleted != null) return deleted;
	        }
	        return null;
	    }

	    /**
	     * Update an OptionSet.
	     *
	     * @param name    the name of OptionSet
	     * @param options new values
	     * @return true if succeeded, false if failed
	     */
	    public boolean updateOptionSet(String name, OptionSet.Option[] options) {
	        final int index = findOptionSet(name);
	        if (index < 0) return false;

	        setOpset(index, new OptionSet(name, options));
	        return true;
	    }

	    /**
	     * Update the value of an Option.
	     *
	     * @param name  the name of the Option
	     * @param price new price
	     * @return true if succeeded, false if failed
	     */
	    public boolean updateOption(String name, float price) {
	        for (final OptionSet optionSet : opset) {
	            final int index = optionSet.findOption(name);
	            if (index < 0) continue;

	            optionSet.setOpt(index, new OptionSet.Option(name, price));
	            return true;
	        }
	        return false;
	    }

	    // Inner classes
	    public class OptionSet implements Serializable {
	        private String name;
	        private Option opt[];

	        private static final long serialVersionUID = 3338121713071019392L;

	        public OptionSet() {
	            this.name = null;
	            this.opt = null;
	        }

	        public OptionSet(String name, int size) {
	            this.name = name;
	            this.opt = new Option[size];

	            for (int i = 0; i < size; i++) {
	                opt[i] = new Option();
	            }
	        }

	        public OptionSet(String name, Option[] opt) {
	            this.name = name;
	            this.opt = opt;
	        }

	        

	        protected String getName() {
	            return name;
	        }

	        protected void setName(String name) {
	            this.name = name;
	        }

	        protected Option getOpt(int index) {
	            return opt[index];
	        }

	        protected void setOpt(int index, Option option) {
	            this.opt[index] = option;
	        }

	        protected Option[] getOpt() {
	            return opt;
	        }

	        protected void setOpt(Option[] opt) {
	            this.opt = opt;
	        }

	        @Override
	        public String toString() {
	            StringBuilder result = new StringBuilder();
	            result.append("name: ").append(name).append('\n');
	            result.append("opt: [\n");

	            for (final Option option : opt) {
	                result.append('\t').append(option.toString()).append('\n');
	            }
	            result.append("]\n");
	            return result.toString();
	        }

	        /**
	         * Find an Option.
	         *
	         * @param name the name of the Option
	         * @return index of the Option,  -1 if not found
	         */
	        protected int findOption(String name) {
	            if (name == null || name.isEmpty()) return -1;

	            for (int i = 0; i < opt.length; ++i) {
	                if (name.equals(opt[i].getName())) {
	                    return i;
	                }
	            }
	            return -1;
	        }

	        /**
	         * Delete an Option.
	         *
	         * @param name the name of the Option
	         * @return the deleted Option, null if not found
	         */
	        protected Option deleteOption(String name) {
	            final int index = findOption(name);
	            if (index < 0) return null;

	            final Option deleted = opt[index];

	            final Option[] newOpt = new Option[opt.length - 1];

	            // Copy values into a new array
	            int i = 0;
	            for (int j = 0; j < opt.length; ++j) {
	                if (j != index) {
	                    newOpt[i++] = opt[j];
	                }
	            }
	            this.opt = newOpt;

	            return deleted;
	        }
	        static class Option implements Serializable {
	            private String name;
	            private float price;

	            private static final long serialVersionUID = -7460957929551256904L;

	            // default constructor
	            public Option() {
	                name = null;
	                price = 0.0f;
	            }

	            public Option(String name, float price) {
	                this.name = name;
	                this.price = price;
	            }

	            protected String getName() {
	                return name;
	            }

	            protected void setName(String name) {
	                this.name = name;
	            }

	            protected float getPrice() {
	                return price;
	            }

	            protected void setPrice(float price) {
	                this.price = price;
	            }

	            @Override
	            public String toString() {
	                StringBuilder result = new StringBuilder();
	                result.append("name: ").append(name).append(", ");
	                result.append("price: ").append(price);
	                return result.toString();
	            }
	        }
	    }
	}

}
	


