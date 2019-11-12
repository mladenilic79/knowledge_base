class Author < ApplicationRecord

  validates_presence_of :author_name, :author_number

  has_many :books
  has_many :themes, through: :books

end
