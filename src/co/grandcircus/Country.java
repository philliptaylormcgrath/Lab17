package co.grandcircus;
//Country Class: Contains populations and country name
public class Country {
		private String name;
		
		private Long population;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getPopulation() {
			return population;
		}

		public void setPopulation(Long population) {
			this.population = population;
		}

		public Country(String name, Long population) {
			super();
			this.name = name;
			this.population = population;
		}

		public Country() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return name + ": Population: " + population;
		}
		
}
