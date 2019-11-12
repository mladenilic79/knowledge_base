class Theme < ApplicationRecord

  validates_presence_of :theme_name, :theme_number

  has_many :books
  has_many :authors, through: :books

end
