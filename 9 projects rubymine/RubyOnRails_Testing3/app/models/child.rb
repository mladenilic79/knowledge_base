class Child < ApplicationRecord

  validates_presence_of :child_name, :child_number

  belongs_to :blog

end
